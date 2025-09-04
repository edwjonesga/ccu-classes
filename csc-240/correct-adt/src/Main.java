public class Main {

    interface TextEditorBuffer {

        /**
         * Appends text to the end of the buffer.
         * @param text the text to append
         */
        void appendText(String text);

        /**
         * Inserts text at a specific index in the buffer.
         * @param index the position at which to insert the text
         * @param text the text to insert
         */
        void insertText(int index, String text);

        /**
         * Undoes the most recent insertion or append operation.
         */
        void undo();

        /**
         * Redoes the most recently undone operation.
         */
        void redo();

        /**
         * Searches for all insertions containing the given text and returns their indices.
         * @param query the text to search for
         * @return a list of indices where the text appears
         */
        List<Integer> search(String query);

        /**
         * Deletes the text at the specified index.
         * @param index the position at which to delete the text
         */
        void delete(int index);

        /**
         * Returns the current state of the text buffer as a single string.
         * @return the concatenated text in the buffer
         */
        String getBufferText();
    }

    // This is a helper class you can use to keep track of the various mutations made to the buffer
    private static class BufferMutation {
        private final String text;
        private final String type; // Either "insertion" or "deletion"
        private final int index;

        public BufferMutation(String text, String type, int index) {
            this.text = text;
            this.type = type;
            this.index = index;
        }

        public String getText() {
            return text;
        }

        public String getType() {
            return type;
        }

        public int getIndex() {
            return index;
        }
    }

    private static class TextEditorBufferImplementation implements TextEditorBuffer {

        // TODO declare your ADTs here

        @Override
        public void appendText(String text) {
            // Implement this
        }

        @Override
        public String getBufferText() {
            // Implement this to return all the text. Do not insert anything just return the text as specified
        }

        @Override
        public void insertText(int index, String text) {
            // Implement this
        }

        @Override
        public void delete(int index) {
            // Implement this to delete the text at that index
        }

        @Override
        public void undo() {
            // Implement this
        }

        @Override
        public void redo() {
            // Implement this
        }

        @Override
        public List<Integer> search(String query) {
            // Implement this and try to make it as efficient as possible
            // it should return the index of where the string was found
        }
    }

    public TextEditorBuffer getEditorBuffer() {
        return new Text
    }
}
