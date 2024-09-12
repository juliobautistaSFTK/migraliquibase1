#!/bin/bash

# Archivos de entrada y salida
DIFF_OUTPUT="salidadeldiff.txt"   # Archivo con la salida del comando comm
CHANGELOG_FILE="diff-changelog.xml"

# Encabezado del archivo XML
cat <<EOF > $CHANGELOG_FILE
<?xml version="1.0" encoding="UTF-8"?>
<databaseChangeLog
    xmlns="http://www.liquibase.org/xml/ns/dbchangelog"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.liquibase.org/xml/ns/dbchangelog
                        http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-3.8.xsd">
EOF

# Añadir cambios al archivo XML
while IFS= read -r line
do
    # Extraer el nombre del archivo de la línea
    file=$(echo "$line" | awk '{print $2}')
    
    # Añadir el archivo al XML
    echo "    <include file=\"$file\"/>" >> $CHANGELOG_FILE
done < "$DIFF_OUTPUT"

# Cierre del archivo XML
cat <<EOF >> $CHANGELOG_FILE
</databaseChangeLog>
EOF

echo "Changelog XML file generated: $CHANGELOG_FILE"

