# Log4JPlayground

Experiments / dabbling with Log4J




## Different Log Levels for Different Classes

By default this app has different log levels for different classes.

- `Barney` class is set at log level `TRACE`
- `Barney` class only outputs to the `family.log` file (not `stdout`
   like the other classes.
- `Fred` and `Family` classes will default to the `root` log level
- Recommended to play with the `src/main/resources/log4j.properties` file
- Output is written to `family.log` by default
- You can play with setting the log level for specific classes using the 
  commented lines in `src/main/resources/log4j.properties` file

## Notes

To my knowledge, it is _not_ necessary to recompile / package the classes if
you're simply making modifications to the `log4j.properties` file and using the
`./run_family.sh` script.  This is because the location for `log4j.properties`
is specified in the commandline in the `./run_family.sh` script.

If you invoke the classes using another method and referencing the JAR, then 
modifications to the `log4j.properties` file will probably require running
`mvn package`.

## Compiling / Running

  # compile / package
  mvn clean package
  # Using mvn exec to run the class
  ./run_family.sh


