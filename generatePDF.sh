#!/bin/bash

javac Solution.java
java Solution > outputNew.tex
pdflatex outputNew.tex
