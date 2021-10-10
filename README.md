# citybike
How to run the test from IDE:
This is a cucumber BDD framework,
run from 'runner' package 'cukes_runner' file
check reports from:
target/cucumber-html-reports/overview-tags.html

Run from terminal:
mvn verify -Dcucumber.options="--tags @wip"
check reports from:
target/cucumber-html-reports/overview-tags.html

Run from cmd:
go to project folder with cmd
execute mvn verify -Dcucumber.options="--tags @wip"
check reports from:
target/cucumber-html-reports/overview-tags.html
