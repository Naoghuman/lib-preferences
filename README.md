Lib-Preferences
===============

A library for `easy` storing simple data to a Preferences.[properties] file in a [JavaFX] &amp; [Maven] application.

Current `version` is `0.0.2-SNAPSHOT` (08.2014).



Content
-------

* [Example](#Example)
* [Requirements](#Requirements)
* [Installation](#Installation)
* [Documentation](#Documentation)
* [Contribution](#Contribution)
* [License](#License)
* [Autor](#Autor)
* [Contact](#Contact)



Example<a name="Example" />
--------

```java
/**
 * The factory <code>de.pro.lib.preferences.api.PreferencesFactory</code> provides a 
 * singleton instance of the Interface <code>de.pro.lib.preferences.api.IPreferences</code>.
 *
 * @author PRo
 * @see de.pro.lib.preferences.api.IPreferences
 */
public final class PreferencesFactory
```

```java
/**
 * Get a <code>String</code> which is associated with the key in application context.
 * 
 * @param key The key which value is searched for.
 * @param def The default value if the key isn't stored.
 * @return The <code>String</code> which is associated with the key or the default value.
 */
PreferencesFactory.getDefault().get(String key, String def);
```

```java
/**
 * Store a <code>String</code> which is associated with the key in application context.
 * 
 * @param key The key for the saved <code>String</code>.
 * @param value The value which will associated with the key.
 */
PreferencesFactory.getDefault().put(String key, String value);
```

```java
/**
 * Get a <code>String</code> which is associated with the key in module context.
 * 
 * @param clazz Defined the module context.
 * @param key The key which value is searched for.
 * @param def The default value if the key isn't stored.
 * @return The <code>String</code> which is associated with the key or the default value.
 */
PreferencesFactory.getDefault().get(Class clazz, String key, String def);
```

```java
/**
 * Store a <code>String</code> which is associated with the key in module context.
 * 
 * @param clazz Defined the module context.
 * @param key The key for the to saved <code>String</code>.
 * @param value The value which will associated with the key.
 */
PreferencesFactory.getDefault().put(Class clazz, String key, String value);
```



Requirements<a name="Requirements" />
------------

* On your system you need [JRE 8] or [JDK 8] installed.
* The library [Lib-Preferences-0.0.2-SNAPSHOT.jar](#Installation).
* The library [Lib-Logger-0.0.2-SNAPSHOT.jar](#Installation).
  * Included is the [log4j-api-2.0.jar].
  * Included is the [log4j-core-2.0.jar].



Installation<a name="Installation" />
------------

* If not installed download the [JRE 8] or the [JDK 8].
  * Optional: To work better with [FXML] files in a [JavaFX] application download the [JavaFX Scene Builder] under 'Additional Resources'.
* Choose your preferred IDE (e.g. [NetBeans], [Eclipse] or [IntelliJ IDEA]) for development.
* Download or clone [Lib-Preferences].
* Download or clone [Lib-Logger].
* Open the projects in your IDE and run them.



Documentation<a name="Documentation" />
-------------

Momentary only the [JavaDoc] in the library itself is available.



Contribution<a name="Contribution" />
------------

* If you find a bug I will be glad if you will report an [Issue].
* If you want to contribute to the project plz fork the project and do a [Pull Request].



License<a name="License" />
-------

PRo-Preferences is licensed under [General Public License 3.0].



Autor<a name="Autor" />
----

Pro-Preferences is maintained by me, Peter Rogge. See [Contact](#Contact).



Contact
-------

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
[log4j-api-2.0.jar]:https://logging.apache.org/log4j/2.0/log4j-web/dependencies.html
[log4j-core-2.0.jar]:https://logging.apache.org/log4j/2.0/log4j-web/dependencies.html
[Maven]:http://maven.apache.org/
[NetBeans]:https://netbeans.org/
[Pull Request]:https://help.github.com/articles/using-pull-requests
[properties]:http://en.wikipedia.org/wiki/.properties


