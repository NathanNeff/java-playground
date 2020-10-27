# Log4JPlayground

## Trying to silence DEBUG messages when using log4j-over-slf4j

- Compare the output of these two scripts:

This is the "good" setup:

    ./run_producer_with_no_interceptor_and_slf4j_log4j.sh

- I want loglevel to be honored from src/main/resources/log4j.properties
- However, I want to use the Interceptor

- The Interceptor uses log4j-over-slf4j which IGNORES my log4j.properties file
  You can see the effect like this:

- ./run_producer_with_interceptor_and_log4j_over_slf4j.sh
- What am I doing wrong?

## Different Output Files

The only (or maybe I should say) simplest way to run the same program
from the same compiled package and output to two different log files is
to have two different `log4j.properties` files.

The `run_familiy_different_output_file.sh` script and the
`log4j.properties.different.output.file` demonstarate this.

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


