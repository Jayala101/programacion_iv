from zeep import Client
from zeep.transports import Transport
from requests import Session

WSDL = "https://interoperabilidad.dinardap.gob.ec/interoperador/consulta?wsdl"

# Si te exigen certificado cliente (.pem):
# session = Session()
# session.cert = ("/ruta/cert.pem", "/ruta/key.pem")
# session.verify = "/ruta/ca.pem"  # o True si confías en el sistema
# transport = Transport(session=session)

transport = Transport()  # sin cert cliente
client = Client(wsdl=WSDL, transport=transport)

# Estos nombres pueden variar según el contrato real (revisa el WSDL).
usuario = "USUARIO"
clave = "CLAVE"
institucion = "COD_INSTITUCION"
servicio = "COD_SERVICIO"

parametros = {
    "parametro": [
        {"nombre": "identificacion", "valor": "0102030405"}
    ]
}

# La operación suele llamarse 'consultar' o similar:
resp = client.service.consultar(
    usuario, clave, institucion, servicio, parametros
)

print(resp)
# Suele venir como estructura con listas de 'campos' (nombre, valor).
# Ejemplo de parseo defensivo:
def flatten(campos):
    out = {}
    if not campos:
        return out
    for c in campos:
        k = c.get("nombre")
        v = c.get("valor")
        if k:
            out[k] = v
    return out

try:
    paquetes = resp.get("paquetes", {}).get("paquete", [])
    for p in paquetes:
        datos = flatten(p.get("campos", {}).get("campo", []))
        print("Resultado:", datos)
except Exception as e:
    print("No pude parsear la respuesta:", e)
