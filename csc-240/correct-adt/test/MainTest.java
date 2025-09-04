import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class MainTest {

    @Test
    public void testAppendText() {
        Main.TextEditorBuffer buffer = new Main().getEditorBuffer();
        buffer.appendText("Hello");
        assertEquals("Hello", buffer.getBufferText());
        buffer.appendText(" World");
        assertEquals("Hello World", buffer.getBufferText());
    }

    @Test
    public void testInsertText() {
        Main.TextEditorBuffer buffer = new Main().getEditorBuffer();
        buffer.appendText("Hello");
        buffer.insertText(1, " World"); // Insert after "Hello"
        assertEquals("Hello World", buffer.getBufferText());

        // Add a search after insertion
        List<Integer> indices = buffer.search("World");
        assertEquals(List.of(1), indices); // "World" appears at index 1
    }

    @Test
    public void testDeleteText() {
        Main.TextEditorBuffer buffer = new Main().getEditorBuffer();
        buffer.appendText("Hello");
        buffer.appendText(" World");
        buffer.delete(1); // Delete " World"
        assertEquals("Hello", buffer.getBufferText());
    }

    @Test
    public void testUndoRedo() {
        Main.TextEditorBuffer buffer = new Main().getEditorBuffer();
        buffer.appendText("Hello");
        buffer.undo();
        assertEquals("", buffer.getBufferText()); // Undo append
        buffer.redo();
        assertEquals("Hello", buffer.getBufferText()); // Redo append
    }

    @Test
    public void testSearch() {
        Main.TextEditorBuffer buffer = new Main().getEditorBuffer();
        buffer.appendText("Hello");
        buffer.appendText(" World");
        buffer.appendText(" Hello Again");
        List<Integer> indices = buffer.search("Hello");
        assertEquals(List.of(0, 2), indices); // "Hello" appears at 0 and 2
    }

    @Test
    public void testDeleteAndUndo() {
        Main.TextEditorBuffer buffer = new Main().getEditorBuffer();
        buffer.appendText("Hello");
        buffer.appendText(" World");
        buffer.delete(1); // Delete " World"
        assertEquals("Hello", buffer.getBufferText());
        buffer.undo();
        assertEquals("Hello World", buffer.getBufferText()); // Undo delete
    }

    @Test
    public void testCombinedOperations() {
        Main.TextEditorBuffer buffer = new Main().getEditorBuffer();
        buffer.appendText("Hello");
        buffer.appendText(" World");
        buffer.insertText(1, " Again"); // Insert after "Hello"
        buffer.delete(1); // Delete " Again"
        assertEquals("Hello World", buffer.getBufferText());
        buffer.undo(); // Undo delete
        assertEquals("Hello Again World", buffer.getBufferText());
        buffer.redo(); // Redo delete
        assertEquals("Hello World", buffer.getBufferText());

        // Add a search after combined operations
        List<Integer> indices = buffer.search("Again");
        assertTrue(indices.isEmpty()); // "Again" was deleted
    }

    @Test
    public void testSearchAfterDelete() {
        Main.TextEditorBuffer buffer = new Main().getEditorBuffer();
        buffer.appendText("Hello");
        buffer.appendText(" World");
        buffer.delete(1); // Delete " World"
        List<Integer> indices = buffer.search("World");
        assertTrue(indices.isEmpty()); // "World" no longer exists
    }

    @Test
    public void testLargeData() {
        Main.TextEditorBuffer buffer = new Main().getEditorBuffer();

        // Append 30 items
        for (int i = 0; i < 30; i++) {
            buffer.appendText("Text" + i + " ");
        }

        // Verify buffer content length
        String bufferContent = buffer.getBufferText();
        assertTrue(bufferContent.contains("Text0"));
        assertTrue(bufferContent.contains("Text29"));
        assertTrue(bufferContent.length() > 150);

        // Perform some searches
        List<Integer> indices = buffer.search("Text10");
        assertEquals(List.of(10), indices);

        indices = buffer.search("Text25");
        assertEquals(List.of(25), indices);

        // Delete an item and ensure it is gone
        buffer.delete(10);
        assertFalse(buffer.getBufferText().contains("Text10"));

        // Undo the delete and verify
        buffer.undo();
        assertTrue(buffer.getBufferText().contains("Text10"));

        // Redo the delete and verify again
        buffer.redo();
        assertFalse(buffer.getBufferText().contains("Text10"));
    }
}
