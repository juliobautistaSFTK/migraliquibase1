#!/bin/bash

# Configuración de contenedores y base de datos
CONTAINER1="mysql-db11"
CONTAINER2="mysql-db12"
USER="root"
PASSWORD="Canada"
DB="mibase1"

# Archivos temporales para almacenar los resultados de las consultas
FILE1=uno
FILE2=dos

# Consultar la base de datos en el contenedor 1 y guardar los resultados
docker exec $CONTAINER1 mysql -u $USER -p$PASSWORD $DB -e "SELECT orderexecuted, filename FROM DATABASECHANGELOG" -B -N > $FILE1

# Consultar la base de datos en el contenedor 2 y guardar los resultados
docker exec $CONTAINER2 mysql -u $USER -p$PASSWORD $DB -e "SELECT orderexecuted, filename FROM DATABASECHANGELOG" -B -N > $FILE2

# Comparar los resultados
echo "Changes in Database 1 but not in Database 2:"
#comm -23 <(sort uno) <(sort dos)
comm -23 uno dos
