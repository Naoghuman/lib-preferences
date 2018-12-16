
Lib-Preferences
===

[![Build Status](https://travis-ci.org/Naoghuman/lib-preferences.svg?branch=master)](https://travis-ci.org/Naoghuman/lib-preferences)
[![license: GPL v3](https://img.shields.io/badge/License-GPL%20v3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)
[![GitHub release](https://img.shields.io/github/release/Naoghuman/lib-preferences.svg)](https://GitHub.com/Naoghuman/lib-preferences/releases/)



Intention
---

Lib-Preferences is a library for `easy` storing simple data to a Preferences.[properties] 
file in a Java(FX) &amp; [Maven] desktop application.

_Image:_ [UML] Lib-Preferences  
![UML-diagram_Lib-Preferences_v0.6.0_2018-12-14_18-14.png][UML-diagram_Lib-Preferences_v0.6.0_2018-12-14_18-14]

> __Hint__  
> The `UML` diagram is created with the `Online Modeling Platform` [GenMyModel].



Content
---

* [Specification](#Specification)
* [Examples](#Examples)
    * [How to save, access data in an _application_ scope](#HowSaAcAppSco)
    * [How to save, access data in a _module_ scope](#HowSaAcModSco)
* [Conventions](#Conventions)
* [Features](#Features)
* [JavaDoc](#JavaDoc)
* [Download](#Download)
* [Requirements](#Requirements)
* [Installation](#Installation)
* [Contribution](#Contribution)
* [License](#License)
* [Autor](#Autor)
* [Contact](#Contact)



Specification<a name="Specification" />
---

With the factory [PreferencesFactory] the developer have all tools to do the 3 main points from this library:
 1. Make the decision between the `application` and the `module` scope.
 3. Let the developer define the `key` which allowed to store or receive a value.
 4. And finally the decision if a `value` should be saved or received.

> `Application` scope means that the `key` must be **unique** in the _hole_ application.  
> `Module` scope means that the `key` must be **unique** in a _package_ scope.

#### _Usage of PreferencesFactory_
```java
/**
 * 1) Starts the factory process.
 * 2) Activate the 'application' scope.
 * 3) Activate the 'package' scope.
 * 4) Defines the 'key'.
 * 5) Returns the 'value' from type 'T'.
 * 6) Stores the value from type 'T'.
 */
PreferencesFactory.create() // 1
        .application()      // 2
        .module(Class)      // 3
        .key(final String)  // 4
        .get(T);            // 5
        .put(T);            // 6
```



Examples<a name="Examples" />
---

### How to save, access data in an _application_ scope<a name="HowSaAcAppSco" />

##### How to save, access a `Double` in an _application_ scope
```java
@Test
public void thirdStepPutGetDoubleReturnsValue() {
    PreferencesFactory.create()
            .application()
            .key("dummy.key6")
            .put(1.2345d);

    double result = PreferencesFactory.create()
            .application()
            .key("dummy.key6")
            .get(5.4321d);
    assertEquals(1.2345d, result, 0);
}
```

which will write following entry in the file `Preferences.properties`:
```java
com.github.naoghuman.lib.preferences.internal.dummy.key6=1.2345
```

##### How to save, access an `Integer` in an _application_ scope
```java
@Test
public void thirdStepPutGetIntegerReturnsValue() {
    PreferencesFactory.create()
            .application()
            .key("dummy.key8")
            .put(123456);

    int result = PreferencesFactory.create()
            .application()
            .key("dummy.key8")
            .get(654321);
    assertTrue(123456 == result);
}
```

which will write following entry in the file `Preferences.properties`:
```java
com.github.naoghuman.lib.preferences.internal.dummy.key8=123456
```


### How to save, access data in a _module_ scope<a name="HowSaAcModSco" />

##### How to save, access a `Boolean` in a _module_ scope
```java
@Test
public void thirdStepPutGetBooleanReturnsValueTrue() {
    PreferencesFactory.create()
            .module(DummyModuleScope.class)
            .key("dummy.key3")
            .put(Boolean.TRUE);

    assertTrue(PreferencesFactory.create()
            .module(DummyModuleScope.class)
            .key("dummy.key3")
            .get(Boolean.TRUE));
}
```

which will write following entry in the file `Preferences.properties`:
```java
dummy.module.scope.dummy.key3=true
```

##### How to save, access a `String` in a _module_ scope
```java
@Test
public void thirdStepPutGetStringReturnsValue() {
    PreferencesFactory.create()
            .module(DummyModuleScope.class)
            .key("dummy.key12")
            .put("hello world");

    String result = PreferencesFactory.create()
            .module(DummyModuleScope.class)
            .key("dummy.key12")
            .get("world hello");
    assertEquals("hello world", result);
}
```

which will write following entry in the file `Preferences.properties`:
```java
dummy.module.scope.dummy.key12=hello world
```



Conventions<a name="Conventions" />
---

In this chapter, the interested developer can find out about all the conventions 
in the library `Lib-Preferences`.
* Lib-Preferences allowed to store simple data in a file `Preferences.properties`.
* The file 'Preferences.properties' will be automatically generated in the `user.dir` 
  (application folder) if needed.
* The stored data can be from type: Boolean, Double, Integer, Long and String.
* The data can be saved in two different scopes (application and module scope):
    * `Application` scope means that the `key` must be __unique__ in the _hole_ application.
    * `Module` scope means that the `key` must be __unique__ in a _package_ scope.
* Over the factory [PreferencesFactory] the developer have access to all functionalities 
  to store and access the data in context from this library.
* Every `function` with `parameters` will be verified by the internal validator 
  [DefaultPreferencesValidator]. For example a String can't be NULL or EMPTY.



Features<a name="Features" />
---

`Lib-Preferencs` have many nice features which simplify the developers task to 
store and access simple data in a Java(FX) application:
* `Lib-Preferences` allowed to store and access simple data (Boolean, Double, Integer,
   Long and String) in a `Preferences.properties` file.
* The file 'Preferences.properties' will be automatically generated in the `application` 
  folder (user.dir) if needed.
* The data can be saved and received in two scopes. The `application` scope means 
  that the `key` must be __unique__ in the _hole_ application while the `module` scope 
  specified that the `key` must __unique__ in a _package_ scope (for more information 
  about this topic plz see the [JavaDoc](#JavaDoc).
* Over the factory [PreferencesFactory] all needed functionalities in context from 
  this library can be access from the developer.
* Every `parameter` in all functionalities will be verified against minimal conditions 
  with the internal validator [DefaultPreferencesValidator]. For example a `String`
  can't be `NULL` or `EMPTY`.
* All functionalities from the classes in the `core` and `internal` packages are 
  tested with `Unittests`.
* The documentation is done very well with an extended `ReadMe` and well written 
  [JavaDoc] commentaries.
* The library is `open source` and licensed under [General Public License 3.0].
* `Lib-Preferences` is a `Java 8` library and can also be used in a [JavaFX] 8
   application.
* The library is programmed with the IDE [NetBeans] as a [Maven] library.
* The library can easily integrated in a foreign project over [Maven Central].
* During the connection from the project with `Travis CI` automatically a build 
  is performed with every commit.
* During the integration from different `badges` from `img.shield.io` the interested 
  reader can easily inform himself about the `build` state, current release and which 
  license is used for this library.



JavaDoc<a name="JavaDoc" />
---

The `JavaDoc` from the library 'Lib-Preferences' can be explored here: [JavaDoc Lib-Preferences v0.6.0]

_Image:_ JavaDoc Lib-Preferences v0.6.0  
![JavaDoc_Lib-Preferences_v0.6.0_2018-12-14_18-23.png][JavaDoc_Lib-Preferences_v0.6.0_2018-12-14_18-23]




Download<a name="Download" />
---

Current `version` is `0.6.0`. Main points in this release are:
* The hole library is completely rewritten to simplify the developers task to store and access simple data from a automatically generated [properties] file.
* The ReadMe from this library is also completely rewritten which contains now new sections like `Examples`, `Conventions` and `Features` from this library.
* The `JavaDoc` from this library is uploaded to the GitHub project and can now received online.

**Maven coordinates**  
```xml
<dependencies>
    <dependency>
        <groupId>com.github.naoghuman</groupId>
        <artifactId>lib-preferences</artifactId>
        <version>0.6.0</version>
    </dependency>
    <dependency>
        <groupId>com.github.naoghuman</groupId>
        <artifactId>lib-logger</artifactId>
        <version>0.6.0</version>
    </dependency>
</dependencies>
```

Download:
* [Release v0.6.0] (12.17.2018 / MM.dd.yyyy)

An `overview` about all existings releases can be found here:
* [Overview] from all releases in Lib-Preferences.



Requirements<a name="Requirements" />
---

* On your system you need [JRE 8] or [JDK 8] installed.
* The library [Lib-Preferences-0.6.0.jar](#Installation).

In the library following dependencies are registered:
* The library [lib-logger-0.6.0.jar](#Installation).
  * Included in `Lib-Logger` is the library [log4j-api-2.10.0.jar].
  * Included is `Lib-Logger` is the library [log4j-core-2.10.0.jar].



Installation<a name="Installation" />
---

* If not installed download the [JRE 8] or the [JDK 8].
  * Optional: To work better with [FXML] files in a [JavaFX] application 
    download the [JavaFX Scene Builder] under 'Additional Resources'.
* Choose your preferred IDE (e.g. [NetBeans], [Eclipse] or [IntelliJ IDEA]) for development.
* Download or clone [Lib-Preferences].
* Download or clone [Lib-Logger].
* Open the projects in your IDE and run them.



Contribution<a name="Contribution" />
---

* If you find a `Bug` I will be glad if you could report an [Issue].
* If you want to contribute to the project plz fork the project and do a [Pull Request].



License<a name="License" />
---

The project `Lib-Preferences` is licensed under [General Public License 3.0].



Autor<a name="Autor" />
---

The project `Lib-Preferences` is maintained by me, Naoghuman (Peter Rogge). See [Contact](#Contact).



Contact<a name="Contact" />
---

You can reach me under <peter.rogge@yahoo.de>.



[//]: # (Images)
[JavaDoc_Lib-Preferences_v0.6.0_2018-12-14_18-23]:https://user-images.githubusercontent.com/8161815/50017844-acf64780-ffcd-11e8-8e53-24ffdfa59fba.png
[UML-diagram_Lib-Preferences_v0.6.0_2018-12-14_18-14]:https://user-images.githubusercontent.com/8161815/50017421-46bcf500-ffcc-11e8-9e49-467f13d3a1bf.png



[//]: # (Links)
[DefaultPreferencesValidator]:https://github.com/Naoghuman/lib-preferences/blob/master/src/main/java/com/github/naoghuman/lib/preferences/internal/DefaultPreferencesValidator.java
[Eclipse]:https://www.eclipse.org/
[FXML]:http://docs.oracle.com/javafx/2/fxml_get_started/jfxpub-fxml_get_started.htm
[General Public License 3.0]:http://www.gnu.org/licenses/gpl-3.0.en.html
[GenMyModel]:https://www.genmymodel.com/
[IntelliJ IDEA]:http://www.jetbrains.com/idea/
[Issue]:https://github.com/Naoghuman/lib-preferences/issues
[JavaDoc Lib-Preferences v0.6.0]:http://naoghuman.github.io/lib-preferences/apidocs
[JavaFX]:http://docs.oracle.com/javase/8/javase-clienttechnologies.htm
[JavaFX Scene Builder]:http://www.oracle.com/technetwork/java/javase/downloads/index.html
[JDK 8]:http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
[JRE 8]:http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html
[Lib-Preferences]:https://github.com/Naoghuman/lib-preferences
[Lib-Logger]:https://github.com/Naoghuman/lib-logger
[log4j-api-2.10.0.jar]:https://logging.apache.org/log4j/2.0/log4j-web/dependencies.html
[log4j-core-2.10.0.jar]:https://logging.apache.org/log4j/2.0/log4j-web/dependencies.html
[Maven]:http://maven.apache.org/
[Maven Central]:https://search.maven.org/
[NetBeans]:https://netbeans.org/
[Overview]:https://github.com/Naoghuman/lib-preferences/releases
[PreferencesFactory]:https://github.com/Naoghuman/lib-preferences/blob/master/src/main/java/com/github/naoghuman/lib/preferences/core/PreferencesFactory.java
[Pull Request]:https://help.github.com/articles/using-pull-requests
[properties]:http://en.wikipedia.org/wiki/.properties
[Release v0.6.0]:https://github.com/Naoghuman/lib-preferences/releases/tag/v0.6.0
[UML]:https://en.wikipedia.org/wiki/Unified_Modeling_Language
