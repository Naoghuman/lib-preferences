Lib-Preferences
===



Intention
---

Lib-Preferences is a library for `easy` storing simple data to a 
Preferences.[properties] file in a [JavaFX] &amp; [Maven] desktop application.

_Image:_ [UML] Lib-Preferences  
![UML-diagram_Lib-Preferences_v0.5.0_2017-07-07_19-56.png][UML-diagram_Lib-Preferences_v0.5.0_2017-07-07_19-56]

> __Hint__  
> The `UML` diagram is created with the `Online Modeling Platform` [GenMyModel].

Current `version` is `0.5.0` (07.08.2017 / MM.dd.yyyy).



Content
---

* [Examples](#Examples)
   - [SimplePreferencesTest#initDefaultAndDropTrue()](#InDeAnDrTr)
   - [SimplePreferencesTest#getDefaultStringInApplicationContext()](#GeDeStInApCo)
   - [SimplePreferencesTest#putStringInApplicationContext()](#PuStInApCo)
   - [SimplePreferencesTest#getDefaultBooleanInModuleContext()](#GeDeBoInMoCo)
   - [SimplePreferencesTest#putBooleanInModuleContext()](#PuBoInMoCo)
* [Api](#Api)
    - [com.github.naoghuman.lib.preferences.core.PreferencesFacade](#PreferencesFacade)
    - [com.github.naoghuman.lib.preferences.core.SimplePreferences](#SimplePreferences)
* [Download](#Download)
* [Requirements](#Requirements)
* [Installation](#Installation)
* [Documentation](#Documentation)
* [Contribution](#Contribution)
* [License](#License)
* [Autor](#Autor)
* [Contact](#Contact)



Examples<a name="Examples" />
---

### SimplePreferencesTest#initDefaultAndDropTrue()<a name="InDeAnDrTr" />

```java
private static final String NORMAL_PATH
        = System.getProperty("user.dir") + File.separator // NOI18N
        + "Preferences.properties"; // NOI18N

/**
 * The file <code>Preferences.properties</code> will only generated if a last 
 * one <code>key-value</code> pair is written to the file.<br>
 * <br>
 * This test will write following statement in the file:<br>
 * <code>com.github.naoghuman.lib.preferences.internal.x=x</code>
 */
@Test
public void initDefaultAndDropTrue() {    
    final File file = new File(NORMAL_PATH);
    assertFalse(NORMAL_PATH + " mustn't exists", file.exists());
  
    PreferencesFacade.getDefault().put("x", "x");
    assertTrue(NORMAL_PATH + " must exists", file.exists());
}
```


### SimplePreferencesTest#getDefaultStringInApplicationContext()<a name="GeDeStInApCo" />

```java
/**
 * Searching in <code>ApplicationContext</code> means in this case that the 
 * engine search for a <code>key=my.string.key1</code> with a prefix 
 * <code>com.github.naoghuman.lib.preferences.internal</code>. So the complete <code>key</code>
 * for the search is <code>com.github.naoghuman.lib.preferences.internal.my.string.key1</code>.<br>
 * <br>
 * If the <code>key</code> is not found in the file <code>Preferences.properties</code>
 * then the <code>default</code> value will returned, in this case <code>x</code>.
 */
@Test
public void getDefaultStringInApplicationContext() {
    final String defaultValue = PreferencesFacade.getDefault().get("my.string.key1", "x");
    assertEquals("x", defaultValue);
}
```


### SimplePreferencesTest#putStringInApplicationContext()<a name="PuStInApCo" />

```java
/**
 * Putting a <code>value</code> in the file <code>Preferences.properties</code> 
 * in <code>ApplicationContext</code> will write in this case following statement 
 * in the file:<br>
 * <code>com.github.naoghuman.lib.preferences.internal.my.string.key2=y</code><br>
 * <br>
 * Searching / writing in <code>ApplicationContext</code> means in this case that the 
 * engine search / write a <code>key=my.string.key2</code> with a prefix 
 * <code>com.github.naoghuman.lib.preferences.internal</code>. So the complete <code>key</code>
 * for the search / to write is <code>com.github.naoghuman.lib.preferences.internal.my.string.key2</code>.<br>
 * <br>
 * Because the search engine find the <code>key</code> in the file not the 
 * <code>default</code> value <code>x</code> will be returned instead the stored 
 * value <code>y</code> will used.
 */
@Test
public void putStringInApplicationContext() {
    PreferencesFacade.getDefault().put("my.string.key2", "y");

    final String storedValue = PreferencesFacade.getDefault().get("my.string.key2", "x");
    assertEquals("y", storedValue);
}
```


### SimplePreferencesTest#getDefaultBooleanInModuleContext()<a name="GeDeBoInMoCo" />

```java
/**
 * Searching in <code>ModuleContext</code> means that the engine search in 
 * the package context from the given <code>class</code>.<br>
 * <br>
 * In the context from the class <code>dummy.module.context.DummyModuleContext</code> 
 * the engine search for a <code>key=my.boolean.key13</code> with a prefix 
 * <code>dummy.module.context</code>. So the complete <code>key</code>
 * for the search is <code>dummy.module.context.my.boolean.key13</code>.<br>
 * <br>
 * Because the <code>key</code> is not found in the file <code>Preferences.properties</code>
 * so the <code>default</code> value will returned, in this case <code>true</code>.
 */
@Test
public void getDefaultBooleanInModuleContext() {
    final boolean defaultValue = PreferencesFacade.getDefault().getBoolean(DummyModuleContext.class, "my.boolean.key13", true);
    assertEquals(true, defaultValue);
}
```


### SimplePreferencesTest#putBooleanInModuleContext()<a name="PuBoInMoCo" />

```java
/**
 * Putting a <code>value</code> in the file <code>Preferences.properties</code> 
 * in <code>ApplicationContext</code> will write in this case following statement 
 * in the file:<br>
 * <code>com.github.naoghuman.lib.preferences.my.string.key2=y</code><br>
 * <br>
 * Searching / writing in <code>ApplicationContext</code> means in this case that the 
 * engine search / write a <code>key=my.string.key2</code> with a prefix 
 * <code>com.github.naoghuman.lib.preferences</code>. So the complete <code>key</code>
 * for the search / to write is <code>com.github.naoghuman.lib.preferences.my.string.key2</code>.<br>
 * <br>
 * Because the search engine find the <code>key</code> in the file not the 
 * <code>default</code> value <code>x</code> will be returned instead the stored 
 * value <code>y</code> will used.
 */
@Test
public void putStringInApplicationContext() {
    PreferencesFacade.getDefault().put("my.string.key2", "y");
        
    final String storedValue = PreferencesFacade.getDefault().get("my.string.key2", "x");
    assertEquals("y", storedValue);
}
```



Api<a name="Api" />
---

### com.github.naoghuman.lib.preferences.core.PreferencesFacade<a name="PreferencesFacade" />

```java
/**
 * The facade {@link com.github.naoghuman.lib.preferences.core.PreferencesFacade} provides 
 * access to the default implementation from the {@code Interface} 
 * {@link com.github.naoghuman.lib.preferences.core.SimplePreferences}.<br>
 * The default implementation from the Interface {@code SimplePreferences} is 
 * {@link com.github.naoghuman.lib.preferences.internal.DefaultPreferences}.
 *
 * @author Naoghuman
 * @see com.github.naoghuman.lib.preferences.core.SimplePreferences
 * @see com.github.naoghuman.lib.preferences.internal.DefaultPreferences
 */
public class PreferencesFacade implements SimplePreferences {
```


```java
/**
 * Returns a singleton instance from the class <code>PreferencesFacade</code>.
 * 
 * @return a singleton instance from the class <code>PreferencesFacade</code>.
 */
public static final PreferencesFacade getDefault()
```


### com.github.naoghuman.lib.preferences.core.SimplePreferences<a name="SimplePreferences" />

```java
/**
 * The {@code Interface} for the default implementation 
 * {@link com.github.naoghuman.lib.preferences.internal.DefaultPreferences}.<br>
 * Over the facade {@link com.github.naoghuman.lib.preferences.core.PreferencesFacade} 
 * you can access to the implementation for the methods in this {@code Interface}.
 *
 * @author Naoghuman
 * @see com.github.naoghuman.lib.preferences.core.PreferencesFacade
 * @see com.github.naoghuman.lib.preferences.internal.DefaultPreferences
 */
public interface SimplePreferences {
```


```java
/**
 * Key constant for accessing the system preferfence file.
 */
public static final String SYSTEM_PREFERENCES__FILE = "SYSTEM_PREFERENCES__FILE"; // NOI18N
```


```java
/**
 * Default value contant for the system preferfence file.
 */
public static final String SYSTEM_PREFERENCES__FILE_DEFAULT_VALUE = "Preferences.properties"; // NOI18N
```


```java
/**
 * Get a {@link java.lang.Boolean} which is associated with the key in application context.
 * 
 * @param key The key which value is searched for.
 * @param def The default value if the key isn't stored.
 * @return The <code>Boolean</code> which is associated with the key or the default value.
 */
public Boolean getBoolean(String key, Boolean def);
```


```java
/**
 * Get a {@link java.lang.Boolean} which is associated with the key in module context.
 * 
 * @param clazz Defined the module context.
 * @param key The key which value is searched for.
 * @param def The default value if the key isn't stored.
 * @return The <code>Boolean</code> which is associated with the key or the default value.
 */
public Boolean getBoolean(Class clazz, String key, Boolean def);
```


```java
/**
 * Stores a {@link java.lang.Boolean} which is associated with the key in application context.
 * 
 * @param key The key for the saved <code>Boolean</code>.
 * @param value The value which will associated with the key.
 */
public void putBoolean(String key, Boolean value);
```


```java
/**
 * Stores a {@link java.lang.Boolean} which is associated with the key in module context.
 * 
 * @param clazz Defined the module context.
 * @param key The key for the to saved <code>Boolean</code>.
 * @param value The value which will associated with the key.
 */
public void putBoolean(Class clazz, String key, Boolean value);
```


```java
/**
 * Get a {@link java.lang.String} which is associated with the key in application context.
 * 
 * @param key The key which value is searched for.
 * @param def The default value if the key isn't stored.
 * @return The <code>String</code> which is associated with the key or the default value.
 */
public String get(String key, String def);
```


```java
/**
 * Get a {@link java.lang.String} which is associated with the key in module context.
 * 
 * @param clazz Defined the module context.
 * @param key The key which value is searched for.
 * @param def The default value if the key isn't stored.
 * @return The <code>String</code> which is associated with the key or the default value.
 */
public String get(Class clazz, String key, String def);
```


```java
/**
 * Stores a {@link java.lang.String} which is associated with the key in application context.
 * 
 * @param key The key for the saved <code>String</code>.
 * @param value The value which will associated with the key.
 */
public void put(String key, String value);
```


```java
/**
 * Stores a {@link java.lang.String} which is associated with the key in module context.
 * 
 * @param clazz Defined the module context.
 * @param key The key for the to saved <code>String</code>.
 * @param value The value which will associated with the key.
 */
public void put(Class clazz, String key, String value);
```


```java
/**
 * Get a {@link java.lang.Double} which is associated with the key in application context.
 * 
 * @param key The key which value is searched for.
 * @param def The default value if the key isn't stored.
 * @return The <code>Double</code> which is associated with the key or the default value.
 */
public Double getDouble( String key, Double def);
```


```java
/**
 * Get a {@link java.lang.Double} which is associated with the key in module context.
 * 
 * @param clazz Defined the module context.
 * @param key The key which value is searched for.
 * @param def The default value if the key isn't stored.
 * @return The <code>Double</code> which is associated with the key or the default value.
 */
public Double getDouble(Class clazz, String key, Double def);
```


```java
/**
 * Stores a {@link java.lang.Double} which is associated with the key in application context.
 * 
 * @param key The key for the saved <code>Double</code>.
 * @param value The value which will associated with the key.
 */
public void putDouble(String key, Double value);
```


```java
/**
 * Stores a {@link java.lang.Double} which is associated with the key in module context.
 * 
 * @param clazz Defined the module context.
 * @param key The key for the to saved <code>Double</code>.
 * @param value The value which will associated with the key.
 */
public void putDouble(Class clazz, String key, Double value);
```


```java
/**
 * Get a {@link java.lang.Integer} which is associated with the key in application context.
 * 
 * @param key The key which value is searched for.
 * @param def The default value if the key isn't stored.
 * @return The <code>Integer</code> which is associated with the key or the default value.
 */
public Integer getInt(String key, Integer def);
```


```java
/**
 * Get a {@link java.lang.Integer} which is associated with the key in module context.
 * 
 * @param clazz Defined the module context.
 * @param key The key which value is searched for.
 * @param def The default value if the key isn't stored.
 * @return The <code>Integer</code> which is associated with the key or the default value.
 */
public Integer getInt(Class clazz, String key, Integer def);
```


```java
/**
 * Stores a {@link java.lang.Integer} which is associated with the key in application context.
 * 
 * @param key The key for the saved <code>Integer</code>.
 * @param value The value which will associated with the key.
 */
public void putInt(String key, Integer value);
```


```java
/**
 * Stores a {@link java.lang.Integer} which is associated with the key in module context.
 * 
 * @param clazz Defined the module context.
 * @param key The key for the to saved <code>Integer</code>.
 * @param value The value which will associated with the key.
 */
public void putInt(Class clazz, String key, Integer value);
```


```java
/**
 * Get a {@link java.lang.Long} which is associated with the key in application context.
 * 
 * @param key The key which value is searched for.
 * @param def The default value if the key isn't stored.
 * @return The <code>Long</code> which is associated with the key or the default value.
 */
public Long getLong(String key, Long def);
```


```java
/**
 * Get a {@link java.lang.Long} which is associated with the key in module context.
 * 
 * @param clazz Defined the module context.
 * @param key The key which value is searched for.
 * @param def The default value if the key isn't stored.
 * @return The <code>Long</code> which is associated with the key or the default value.
 */
public Long getLong(Class clazz, String key, Long def);
```


```java
/**
 * Stores a {@link java.lang.Long} which is associated with the key in application context.
 * 
 * @param key The key for the saved <code>Long</code>.
 * @param value The value which will associated with the key.
 */
public void putLong(String key, Long value);
```


```java
/**
 * Stores a {@link java.lang.Long} which is associated with the key in module context.
 * 
 * @param clazz Defined the module context.
 * @param key The key for the to saved <code>Long</code>.
 * @param value The value which will associated with the key.
 */
public void putLong(Class clazz, String key, Long value);
```


```java
/**
 * Initialize the <code>Preferences.properties</code> file.<br>
 * That means that the <code>Preferences.properties</code> file will created
 * under <code>System.getProperty("user.dir") + File.separator
 * + "Preferences.properties"</code>.
 * 
 * @param drop Should an existing file dropped at frist?
 */
public void init(boolean drop);
```


```java
/**
 * Allowed access to the <code>Preferences</code> in application context. You can
 * for example add a {@link java.util.prefs.PreferenceChangeListener PreferenceChangeListener}
 * to listen for changes in specific preferences.
 * 
 * @return The <code>Preferences</code> in application context.
 */
public Preferences forApplication();
```


```java
/**
 * Allowed access to the <code>Preferences</code> in module context. You can
 * for example add a {@link java.util.prefs.PreferenceChangeListener PreferenceChangeListener}
 * to listen for changes in specific preferences.
 * 
 * @param clazz The class in which defined the module.
 * @return The <code>Preferences</code> in module context.
 */
public Preferences forModule(Class clazz);
```



Download<a name="Download" />
---

Current `version` is `0.5.0`. Main points in this release are:
* This is a major update.
* Create new package structure to reflect my new library conventions.
* Deprecated all old classes and interfaces.
* Update the readme to reflect the changes.

**Maven coordinates**  
```xml
<dependencies>
    <dependency>
        <groupId>com.github.naoghuman</groupId>
        <artifactId>lib-preferences</artifactId>
        <version>0.5.0</version>
    </dependency>
    <dependency>
        <groupId>com.github.naoghuman</groupId>
        <artifactId>lib-logger</artifactId>
        <version>0.5.0</version>
    </dependency>
</dependencies>
```

Download:
* [Release v0.5.0 (07.08.2017 / MM.dd.yyyy)]

An `overview` about all existings releases can be found here:
* [Overview from all releases in Lib-Preferences]



Requirements<a name="Requirements" />
---

* On your system you need [JRE 8] or [JDK 8] installed.
* The library [Lib-Preferences-0.5.0.jar](#Installation).

In the library are following libraries registered as dependencies:
* The library [Lib-Logger-0.5.0.jar](#Installation).
  * Included in `Lib-Logger` is the library [log4j-api-2.8.2.jar].
  * Included is `Lib-Logger` is the library [log4j-core-2.8.2.jar].



Installation<a name="Installation" />
---

* If not installed download the [JRE 8] or the [JDK 8].
  * Optional: To work better with [FXML] files in a [JavaFX] application 
    download the [JavaFX Scene Builder] under 'Additional Resources'.
* Choose your preferred IDE (e.g. [NetBeans], [Eclipse] or [IntelliJ IDEA]) for development.
* Download or clone [Lib-Preferences].
* Download or clone [Lib-Logger].
* Open the projects in your IDE and run them.



Documentation<a name="Documentation" />
---

* In the section [Examples](#Examples) you can see different examples to put and
  get simple data in the your custom file `Preferences.properties`.
* In the section [Api](#Api) you can see the main point(s) to access the functionality 
  in this library.
* For additional information see the [JavaDoc] in the library itself.



Contribution<a name="Contribution" />
---

* If you find a `Bug` I will be glad if you could report an [Issue].
* If you want to contribute to the project plz fork the project and do a [Pull Request].



License<a name="License" />
---

The project `Lib-Preferences` is licensed under [General Public License 3.0].



Autor<a name="Autor" />
---

The project `Lib-Preferences` is maintained by me, Peter Rogge. See [Contact](#Contact).



Contact<a name="Contact" />
---

You can reach me under <peter.rogge@yahoo.de>.



[//]: # (Images)
[UML-diagram_Lib-Preferences_v0.5.0_2017-07-07_19-56]:https://user-images.githubusercontent.com/8161815/27970427-135599b2-634f-11e7-8bad-98bb3601f493.png



[//]: # (Links)
[Eclipse]:https://www.eclipse.org/
[FXML]:http://docs.oracle.com/javafx/2/fxml_get_started/jfxpub-fxml_get_started.htm
[General Public License 3.0]:http://www.gnu.org/licenses/gpl-3.0.en.html
[GenMyModel]:https://www.genmymodel.com/
[IntelliJ IDEA]:http://www.jetbrains.com/idea/
[Issue]:https://github.com/Naoghuman/lib-preferences/issues
[JavaDoc]:http://www.oracle.com/technetwork/java/javase/documentation/index-jsp-135444.html
[JavaFX]:http://docs.oracle.com/javase/8/javase-clienttechnologies.htm
[JavaFX Scene Builder]:http://www.oracle.com/technetwork/java/javase/downloads/index.html
[JDK 8]:http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
[JRE 8]:http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html
[Lib-Preferences]:https://github.com/Naoghuman/lib-preferences
[Lib-Logger]:https://github.com/Naoghuman/lib-logger
[log4j-api-2.8.2.jar]:https://logging.apache.org/log4j/2.0/log4j-web/dependencies.html
[log4j-core-2.8.2.jar]:https://logging.apache.org/log4j/2.0/log4j-web/dependencies.html
[Maven]:http://maven.apache.org/
[NetBeans]:https://netbeans.org/
[Overview from all releases in Lib-Preferences]:https://github.com/Naoghuman/lib-preferences/releases
[Pull Request]:https://help.github.com/articles/using-pull-requests
[properties]:http://en.wikipedia.org/wiki/.properties
[Release v0.5.0 (07.08.2017 / MM.dd.yyyy)]:https://github.com/Naoghuman/lib-preferences/releases/tag/v0.5.0
[UML]:https://en.wikipedia.org/wiki/Unified_Modeling_Language


