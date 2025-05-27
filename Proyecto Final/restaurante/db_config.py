import cx_Oracle

password = "1234"

try:
    # Intentar con el usuario C##MARIA
    cx_Oracle.connect("C##MARIA", password, "localhost/XE")
    db_user = "C##MARIA"
except cx_Oracle.DatabaseError:
    # Si falla, usar C##RAMOS
    db_user = "C##RAMOS"

db_password = password