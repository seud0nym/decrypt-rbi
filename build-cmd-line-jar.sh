#!/bin/sh

[ -e target ] && rm -rf target
mkdir -p target/classes
javac -Djava.ext.dirs= -d target/classes $(find src -type f -name '*.java')
cp src/main/resources/* target/classes

VERSION=$(sed -n -e '/<build>/,/<\/build>/d' -e 's/^[[:blank:]]*//' -e '/version/s/<[^>]*>//g p' pom.xml)

[ -e bin ] && rm -rf bin
mkdir bin
sed -e "\$aImplementation-Version: v$VERSION-$(date +%Y%m%d)" src/META-INF/MANIFEST.MF > bin/MANIFEST.MF
jar cfm bin/decrypt-rbi.jar bin/MANIFEST.MF -C target/classes .
