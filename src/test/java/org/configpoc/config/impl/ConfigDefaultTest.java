package org.configpoc.config.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.configpoc.builder.Parameters;
import org.configpoc.config.Config;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Stream;

class ConfigDefaultTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigDefaultTest.class);

    @Test
    public void getInt() {

        LOGGER.info("getInt");

        ConfigDefault configDefault=new ConfigDefault(createMap("key1","15","key2","bbb"),new Parameters());

        // methode testée
        final int val=configDefault.getInt("key1");

        // vérifications
        assertEquals(15,val);
    }

    private static Stream<Arguments> provideGetInt() {
        return Stream.of(
                Arguments.of(createMap("key1","15","key2","bbb"), "key1", 15),
                Arguments.of(createMap("key1","6325","key2","bbb"), "key1", 6325),
                Arguments.of(createMap("key01","6325","key50","951"), "key50", 951),
                Arguments.of(createMap("key1","-753","key2","bbb"), "key1", -753)
        );
    }

    @ParameterizedTest
    @MethodSource("provideGetInt")
    public void getInt(final Map<String,String> map, final String key, final int refVal) {

        ConfigDefault configDefault=new ConfigDefault(map,new Parameters());

        // methode testée
        final int val=configDefault.getInt(key);

        // vérifications
        assertEquals(refVal,val);
    }

    private static Stream<Arguments> provideGetLong() {
        return Stream.of(
                Arguments.of(createMap("key1","15","key2","bbb"), "key1", 15L),
                Arguments.of(createMap("key1","6325","key2","bbb"), "key1", 6325L),
                Arguments.of(createMap("key01","6325","key50","951"), "key50", 951L),
                Arguments.of(createMap("key1","-753","key2","bbb"), "key1", -753L)
        );
    }

    @ParameterizedTest
    @MethodSource("provideGetLong")
    public void getLong(final Map<String,String> map, final String key, final long refVal) {

        ConfigDefault configDefault=new ConfigDefault(map,new Parameters());

        // methode testée
        final long val=configDefault.getLong(key);

        // vérifications
        assertEquals(refVal,val);
    }

    private static Stream<Arguments> provideGetBoolean() {
        return Stream.of(
                Arguments.of(createMap("key1","true","key2","bbb"), "key1", true),
                Arguments.of(createMap("key1","false","key2","bbb"), "key1", false),
                Arguments.of(createMap("key01","false","key50","TRUE"), "key50", true),
                Arguments.of(createMap("key1","FALSE","key2","bbb"), "key1", false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideGetBoolean")
    public void getBoolean(final Map<String,String> map, final String key, final boolean refVal) {

        ConfigDefault configDefault=new ConfigDefault(map,new Parameters());

        // methode testée
        final boolean val=configDefault.getBoolean(key);

        // vérifications
        assertEquals(refVal,val);
    }

    private static Stream<Arguments> provideGetChar() {
        return Stream.of(
                Arguments.of(createMap("key1","a","key2","bbb"), "key1", 'a'),
                Arguments.of(createMap("key1","b","key2","bbb"), "key1", 'b'),
                Arguments.of(createMap("key01","false","key50"," "), "key50", ' '),
                Arguments.of(createMap("key1",".","key2","bbb"), "key1", '.')
        );
    }

    @ParameterizedTest
    @MethodSource("provideGetChar")
    public void getChar(final Map<String,String> map,final String key,final char refVal) {

        ConfigDefault configDefault=new ConfigDefault(map,new Parameters());

        // methode testée
        final char val=configDefault.getChar(key);

        // vérifications
        assertEquals(refVal,val);
    }

    private static Stream<Arguments> provideGetFloat() {
        return Stream.of(
                Arguments.of(createMap("key1","1.0","key2","bbb"), "key1", 1.0f),
                Arguments.of(createMap("key1","156.354","key2","bbb"), "key1", 156.354f),
                Arguments.of(createMap("key01","false","key50","954.368"), "key50", 954.368f),
                Arguments.of(createMap("key1","-0.235","key2","bbb"), "key1", -0.235f)
        );
    }

    @ParameterizedTest
    @MethodSource("provideGetFloat")
    public void getFloat(final Map<String,String> map, final String key,final float refVal) {

        ConfigDefault configDefault=new ConfigDefault(map,new Parameters());

        // methode testée
        final float val=configDefault.getFloat(key);

        // vérifications
        assertEquals(refVal,val);
    }

    private static Stream<Arguments> provideGetDouble() {
        return Stream.of(
                Arguments.of(createMap("key1","321.654","key2","bbb"), "key1", 321.654),
                Arguments.of(createMap("key1","0.568","key2","bbb"), "key1", 0.568),
                Arguments.of(createMap("key01","false","key50","-845.4"), "key50", -845.4),
                Arguments.of(createMap("key1","63.1","key2","bbb"), "key1", 63.1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideGetDouble")
    public void getDouble(final Map<String,String> map, final String key, final double refVal) {

        ConfigDefault configDefault=new ConfigDefault(map,new Parameters());

        // methode testée
        final double val=configDefault.getDouble(key);

        // vérifications
        assertEquals(refVal,val);
    }

    private static Stream<Arguments> provideGetString() {
        return Stream.of(
                Arguments.of(createMap("key1","azaet","key2","bbb"), "key1", "azaet"),
                Arguments.of(createMap("key1","ds 4f 5d0s4f50fdcs (_;jkljkl","key2","bbb"), "key1", "ds 4f 5d0s4f50fdcs (_;jkljkl"),
                Arguments.of(createMap("key01","74165","key50","   "), "key50", "   "),
                Arguments.of(createMap("key1"," adfdsf","key2","bbb"), "key1", " adfdsf")
        );
    }

    @ParameterizedTest
    @MethodSource("provideGetString")
    public void getString(final Map<String,String> map, final String key, final String refVal) {

        ConfigDefault configDefault=new ConfigDefault(map,new Parameters());

        // methode testée
        final String val=configDefault.getString(key);

        // vérifications
        assertEquals(refVal,val);
    }

    private static Stream<Arguments> provideGetKeys() {
        return Stream.of(
                Arguments.of(createMap("key1","azaet","key2","bbb"), createSet("key1", "key2")),
                Arguments.of(createMap("key1","aaa","key2","bbb", "key3", "ccc"), createSet("key1", "key2", "key3")),
                Arguments.of(createMap("key01","74165","key50","   "), createSet("key01", "key50")),
                Arguments.of(createMap("key1","aa"), createSet("key1")),
                Arguments.of(createMap(), createSet())
        );
    }

    @ParameterizedTest
    @MethodSource("provideGetKeys")
    public void getKeys(final Map<String,String> map, final Set<String> refVal) {
        ConfigDefault configDefault=new ConfigDefault(map,new Parameters());

        // methode testée
        final Set<String> set=configDefault.getKeys();

        // vérifications
        assertEquals(refVal, set);
    }

    @Test
    public void getConfig() {
        final Map<String,String> map;

        map=createMap("key1","azaet","key2","bbb","key3.key31","ccc001", "key3.key32", "ccc002");

        ConfigDefault configDefault=new ConfigDefault(map,new Parameters());

        // methode testée
        final Config config=configDefault.getConfig("key3");

        // vérifications
        assertNotNull(config);
        assertEquals(createSet("key31","key32"), config.getKeys());
        assertEquals("ccc001",config.getString("key31"));
        assertEquals("ccc002",config.getString("key32"));
    }

    // methodes utilitaires

    private static Map<String,String> createMap(String... tab){
        Map<String,String> map=new HashMap<>();
        if(tab!=null) {
            assertEquals(0, tab.length % 2);
            for (int i = 0; i < tab.length; i += 2) {
                String key = tab[i];
                String value = tab[i + 1];
                assertNotNull(key);
                map.put(key, value);
            }
        }
        return map;
    }
    private static Set<String> createSet(String... tab){
        Set<String> set=new HashSet<>();
        if(tab!=null&&tab.length>0) {
            set.addAll(Arrays.asList(tab));
        }
        return set;
    }
}