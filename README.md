# Books

Simple but over-engineered Google Books API CLI app in Java

## Requirements

* Java 8
* Gradle

## Setup & Build

Just run `gradle jar` from the app root. This will handle dependencies, build and package the app.

## Running the app

After building the jar you can run the app with:

```
java -jar build/libs/books-1.0-SNAPSHOT.jar <search term>
```

Because this long command is tedious, there is a shell script to help:

```
bin/books <search term>
```

**TODO**: demo the app...

## Notes about implementation

**TODO - Explain**

* Hexagonal architecture
* Vertical slicing
* overall over-engineering just for show
