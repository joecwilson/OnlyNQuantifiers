#!/bin/bash

javac Solution.java
java Solution > output.tex
pdflatex output.tex > .log.txt
