microservice-dump
=================

A small program that will perform an [ncdump](https://www.unidata.ucar.edu/software/netcdf/netcdf-4/newdocs/netcdf/ncdump.html) on a given http accessible [NetCDF](https://www.unidata.ucar.edu/software/netcdf/) file.


## Packaging

To create a deployment please use the [spring-boot-maven-plugin](http://docs.spring.io/spring-boot/docs/current/maven-plugin/).

Example:
```
$ mvn package spring-boot:repackage
```

## Deployment

After packaging the self executing jar, move the jar file to where it will be deployed and run the following command:
```
$ java -jar ncdump-<VERSION>.jar
```

## Example

To use the webservice:
```
$ curl http://localhost:8080/api/v1.0.0/ncdump?url=https://www.earthsystemgrid.org/download/fileDownload.html?logicalFileId=81c47938-1648-11e3-864b-00c0f03d5b7c
```

The above file is from the [NARCCAP](http://www.narccap.ucar.edu/) regional climate model.

NARCCAP data is freely available from the [Earth System Grid](https://www.earthsystemgrid.org/project/narccap.html).