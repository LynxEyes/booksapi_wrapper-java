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

### Architecture

I've tried to follow 2 architectural patterns here: Hexagonal Architecture and UseCases.
This is an overkill for such a simple app and I've only done it as a means of demonstration.

**How does the Hexagonal Architecture (or _Ports and Adapters_) part of this is structured?**

The app has a core, this core exposes an API for consumers to call and obtain responses from the app - in this case book listings.
In the light of this architecture, this would be called a _port_.

This same core exposes a set of interfaces to communicate with data providers. A data provider implementation must be provided to the app for it to run.
This would be called an _adapter_.

This is all tied together with a IoC container and Dependency Injection. Although it might be possible to do this kind of architecture without those concepts, I fail to understand how.

**And what about the UseCases?**

Well, there are a number of ways to build the _ports_ of a Ports and Adapters kind of architecture. I've done it with _Services_ that expose the callable API of the core, these are usually organized by a set of functionalities that go together or by entities.
There is also the "UseCase" way, which are no more than _callable objects_. Each represents a capability of the core and they can be used in blocks to provide broader capabilities.

I do like the UseCase approach, it feels composable, but can get hairy pretty quick if you start to build too many composed capabilities.

**So, why the overkill?**

Because I like to try new things and I don't have large project to apply these patterns to on my free time.
This is like those convoluted "hello world" programs you see on workshops and conference presentations.

### Vertical Slicing

This is an organizational concept. The idea behind it is that you should slice your app into vertical slices, instead of the traditional horizontal ones.

Typical apps are organized in horizontal slicing, where you have a package for models, a package for repositories, a package for services/usecases, etc..
On vertical slicing you'd have a package for your entity or functionality and inside that you'll have your models, repositories, services, etc..

This is not my idea, not by a long shot. This is drawn from Oliver Gierke's presentation [
Whoops! Where did my architecture go?](https://speakerdeck.com/olivergierke/whoops-where-did-my-architecture-go-2). Have a look, its amazing!


## TODO

* Integration tests @ Core level
* Maybe kill the usage of Spectrum...
