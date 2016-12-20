# PSL-Automation-Interview
This is the repository where I upload my test automation interview practice exercise

# How to run the project

exectute the following maven command:

**mvn clean verify**

with the last command the project will execute in firefox using marrionete driver, if you want to run the project in other browser use the following command:

**mvn clean verify -Ddriver={browserName}**

the supported browsers are chrome, firefox and edge.

If you want to generate the reports in a custom directory use the following command:

**mvn clean verify -Ddriver={browserName}  -Dserenity.outputDirectory={path}**

as an example to run the project in chrome use 
**mvn clean verify -Ddriver=chrome  -Dserenity.outputDirectory=target/site/serenity/ReporteChrome**

## IMPORTANT

To have a succes execution of the project, in the system must be registered a pacient withd the following data:

Nombre Ricardo
Documento: 1013595642

And a Doctor with the following data:

Nombre Andres
Documento 1016024776

If one of this users are not registered the suite test execution will not be the expected. 
