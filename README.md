## My Gatling Test Suite - performance test suite

Project uses [sbt plugin][sbtplugindoc] of [gatling][gatlingdoc].
It contains basic simulation from gatling quick start bundle.

[sbtplugindoc]: https://gatling.io/docs/current/extensions/sbt_plugin/
[gatlingdoc]: https://gatling.io/docs/current/advanced_tutorial/

### Run

All tests:
```
sbt "gatling:test"
```

Single test:
```
sbt "gatling:testOnly com.sample.UserSimulation"
```

Report:
```
sbt "gatling:lastReport"
```

### Package

### JAR

Build:
```
sbt "test:assembly"
```

Run:
```
java -jar target/scala-2.12/app.jar -s com.sample.UserSimulation
```