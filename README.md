Lib-Preferences
===



Intention
---

Lib-Preferences is a library for `easy` storing simple data to a 
Preferences.[properties] file in a [JavaFX] &amp; [Maven] desktop application.

Current `version` is `0.2.1` (08.2015).



Content
---

* [Examples](#Examples)
   - [com.github.naoghuman.lib.database.LibPreferencesTest#initDefaultAndDropTrue()](#InitDefaultAndDropTrue)
   - [com.github.naoghuman.lib.database.LibPreferencesTest#getStringInApplicationContext()](#GetStringInApplicationContext)
   - [com.github.naoghuman.lib.database.LibPreferencesTest#putStringInApplicationContext()](#PutStringInApplicationContext)
   - [com.github.naoghuman.lib.database.LibPreferencesTest#getBooleanInModuleContext()](#GetBooleanInModuleContext)
   - [com.github.naoghuman.lib.database.LibPreferencesTest#putBooleanInModuleContext()](#PutBooleanInModuleContext)
* [Api](#Api)
    - [com.github.naoghuman.lib.preferences.api.PreferencesFacade](#PreferencesFacade)
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

### com.github.naoghuman.lib.database.LibPreferencesTest#initDefaultAndDropTrue()<a name="InitDefaultAndDropTrue" />

```java
private static final String NORMAL_PATH
        = System.getProperty("user.dir") + File.separator // NOI18N
        + "Preferences.properties"; // NOI18N

@Test
public void initDefaultAndDropTrue() {
    final File file = new File(NORMAL_PATH);
    assertFalse(NORMAL_PATH + " mustn't exists", file.exists());
  
    PreferencesFacade.getDefault().put("x", "x");
    assertTrue(NORMAL_PATH + " must exists", file.exists());
}
```


### com.github.naoghuman.lib.database.LibPreferencesTest#getStringInApplicationContext()<a name="GetStringInApplicationContext" />

```java
@Test
public void getStringInApplicationContext() {
    final String x = PreferencesFacade.getDefault().get("my.string.key1", "x");
    assertEquals("x", x);
}
```


### com.github.naoghuman.lib.database.LibPreferencesTest#putStringInApplicationContext()<a name="PutStringInApplicationContext" />

```java
Test
public void putStringInApplicationContext() {
    PreferencesFacade.getDefault().put("my.string.key2", "y");
    final String y = PreferencesFacade.getDefault().get("my.string.key2", "x");
    assertEquals("y", y);
}
```


### com.github.naoghuman.lib.database.LibPreferencesTest#getBooleanInModuleContext()<a name="GetBooleanInModuleContext" />

```java
@Test
public void getBooleanInModuleContext() {
    final boolean x = PreferencesFacade.getDefault().getBoolean(DummyModuleContext.class, "my.boolean.key13", true);
    assertEquals(true, x);
}
```


### com.github.naoghuman.lib.database.LibPreferencesTest#putBooleanInModuleContext()<a name="PutBooleanInModuleContext" />

```java
@Test
public void putBooleanInModuleContext() {
    PreferencesFacade.getDefault().putBoolean(DummyModuleContext.class, "my.boolean.key14", false);
    final boolean y = PreferencesFacade.getDefault().getBoolean(DummyModuleContext.class, "my.boolean.key14", true);
    assertEquals(false, y);
}
```



Api<a name="Api" />
---

### com.github.naoghuman.lib.preferences.api.PreferencesFacade<a name="PreferencesFacade" />

```java
/**
 * The facade {@link com.github.naoghuman.lib.preferences.api.PreferencesFacade} provides 
 * access to the Interface {@link com.github.naoghuman.lib.preferences.api.ILibPreferences}.
 *
 * @author PRo
 * @see com.github.naoghuman.lib.preferences.api.ILibPreferences
 */
public final class PreferencesFacade implements ILibPreferences {
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
 * Initialize the <code>Preferences.properties</code> file.<br />
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

Current `version` is `0.2.1`. Main points in this release are:
* Implement in PreferencesFacade directly the interface ILibPreferences for 
  easier handling.
* Add new section Api to the ReadMe.
* Add new section Download to the ReadMe.
* Add new section Intention to the ReadMe.
* Extend the section Examples in the ReadMe.

Download:
* [Release v0.2.1 (08.2015)]

An overview about all existings releases can be found here:
* [Overview from all releases in Lib-Preferences]



Requirements<a name="Requirements" />
---

* On your system you need [JRE 8] or [JDK 8] installed.
* The library [Lib-Preferences-0.2.1.jar](#Installation).
* The library [Lib-Logger-0.3.0.jar](#Installation).
  * Included is the [log4j-api-2.4.1.jar].
  * Included is the [log4j-core-2.4.1.jar].



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

* In section [Api](#Api) you can see the main point(s) to access the functionality 
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


[//]: # (Links)
[Eclipse]:https://www.eclipse.org/
[FXML]:http://docs.oracle.com/javafx/2/fxml_get_started/jfxpub-fxml_get_started.htm
[General Public License 3.0]:http://www.gnu.org/licenses/gpl-3.0.en.html
[IntelliJ IDEA]:http://www.jetbrains.com/idea/
[Issue]:https://github.com/Naoghuman/lib-preferences/issues
[JavaDoc]:http://www.oracle.com/technetwork/java/javase/documentation/index-jsp-135444.html
[JavaFX]:http://docs.oracle.com/javase/8/javase-clienttechnologies.htm
[JavaFX Scene Builder]:http://www.oracle.com/technetwork/java/javase/downloads/index.html
[JDK 8]:http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
[JRE 8]:http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html
[Lib-Preferences]:https://github.com/Naoghuman/lib-preferences
[Lib-Logger]:https://github.com/Naoghuman/lib-logger
[log4j-api-2.4.1.jar]:https://logging.apache.org/log4j/2.0/log4j-web/dependencies.html
[log4j-core-2.4.1.jar]:https://logging.apache.org/log4j/2.0/log4j-web/dependencies.html
[Maven]:http://maven.apache.org/
[NetBeans]:https://netbeans.org/
[Overview from all releases in Lib-Preferences]:https://github.com/Naoghuman/lib-preferences/releases
[Pull Request]:https://help.github.com/articles/using-pull-requests
[properties]:http://en.wikipedia.org/wiki/.properties
[Release v0.2.1 (08.2015)]:https://github.com/Naoghuman/lib-preferences/releases/tag/v0.2.1


