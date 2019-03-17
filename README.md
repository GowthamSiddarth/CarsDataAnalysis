# CarsDataAnalysis
A practice repository for implementing quicker processing of queries for a particular use case

## Build
mvn clean package

## Run
java -jar {path/to/jar} --file {path/to/dataset} -n {numOfCars} --origin {origin} [--no-header]

Make sure 'libs' generated inside target dir after "Build" is present in the same dir as the jar. Otherwise, use -cp arg
to the libs dir.