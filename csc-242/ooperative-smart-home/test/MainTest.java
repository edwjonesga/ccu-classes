import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    
    private static Class<?> homeControllerClass;
    private static List<Class<?>> smartDeviceTypes;
    private static Class<?> smartDeviceType;
    private static Class<?> smartLightType;
    private static Class<?> smartLockType;
    private static Class<?> securityDeviceType;
    
    @BeforeAll
    static void setup() {
        homeControllerClass = Main.getHomeControllerType();
        try {
            Method getSmartDeviceTypesMethod = homeControllerClass.getMethod("getSmartDeviceTypes");
            smartDeviceTypes = (List<Class<?>>) getSmartDeviceTypesMethod.invoke(homeControllerClass.getDeclaredConstructor().newInstance());
        } catch (Exception e) {
            fail("HomeController must have a getSmartDeviceTypes method that returns a list of SmartDevice types.");
        }
        smartDeviceType = Main.getSmartDeviceType();
        smartLightType = Main.getSmartLightType();
        smartLockType = Main.getSmartLockType();
        securityDeviceType = Main.getSecurityDeviceType();
    }
    
    @Test
    void testHomeControllerExists() {
        assertNotNull(homeControllerClass, "HomeController class must be defined.");
    }
    
    @Test
    void testHomeControllerHasNoArgConstructor() {
        try {
            Constructor<?> constructor = homeControllerClass.getDeclaredConstructor();
            assertNotNull(constructor, "HomeController must have a no-argument constructor.");
        } catch (NoSuchMethodException e) {
            fail("HomeController must have a no-argument constructor.");
        }
    }
    
    @Test
    void testSmartDeviceTypesExist() {
        assertNotNull(smartDeviceTypes, "getSmartDeviceTypes must return a non-null list.");
        assertFalse(smartDeviceTypes.isEmpty(), "getSmartDeviceTypes must return at least one type.");
    }
    
    @Test
    void testSmartDeviceTypeIsInterface() {
        assertNotNull(smartDeviceType, "SmartDevice interface must be defined.");
        assertTrue(smartDeviceType.isInterface(), "SmartDevice must be an interface.");
    }
    
    @Test
    void testSmartDeviceTypesExtendSmartDevice() {
        for (Class<?> deviceType : smartDeviceTypes) {
            assertTrue(smartDeviceType.isAssignableFrom(deviceType), 
                deviceType.getName() + " must implement SmartDevice interface.");
        }
    }
    
    @Test
    void testSpecificDeviceTypesExist() {
        assertNotNull(smartLightType, "SmartLight type must be defined.");
        assertNotNull(smartLockType, "SmartLock type must be defined.");
        assertNotNull(securityDeviceType, "SecurityDevice type must be defined.");
    }
    
    @Test
    void testSpecificDeviceTypesImplementSmartDevice() {
        assertTrue(smartDeviceType.isAssignableFrom(smartLightType), "SmartLight must implement SmartDevice.");
        assertTrue(smartDeviceType.isAssignableFrom(smartLockType), "SmartLock must implement SmartDevice.");
        assertTrue(smartDeviceType.isAssignableFrom(securityDeviceType), "SecurityDevice must implement SmartDevice.");
    }
    
    @Test
    void testHomeControllerHasSmartDeviceMethods() {
        for (Class<?> deviceType : smartDeviceTypes) {
            String deviceName = deviceType.getSimpleName();
            try {
                Method listMethod = homeControllerClass.getMethod("get" + deviceName + "List");
                assertTrue(List.class.isAssignableFrom(listMethod.getReturnType()), 
                    "get" + deviceName + "List must return a List.");
                
                Type returnType = listMethod.getGenericReturnType();
                assertTrue(returnType instanceof ParameterizedType, "Expected a parameterized list type for get" + deviceName + "List.");
                Type actualType = ((ParameterizedType) returnType).getActualTypeArguments()[0];
                assertEquals(deviceType, actualType, "get" + deviceName + "List must return a list of " + deviceType.getName());
                
                Method singleMethod = homeControllerClass.getMethod("get" + deviceName, String.class);
                assertNotNull(singleMethod, "get" + deviceName + " must exist and take a String parameter.");
                assertEquals(deviceType, singleMethod.getReturnType(), "get" + deviceName + " must return the expected type " + deviceType.getName());
                
            } catch (NoSuchMethodException e) {
                fail("HomeController must have methods to retrieve instances of " + deviceName);
            }
        }
    }
}
