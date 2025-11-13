# Conversor VIA · ONE G9 💱

Mini-proyecto en Java del programa **Oracle ONE / Alura**.  
Primer paso público de **JP Serra (VIA Servicios Digitales)** hacia el back-end profesional.

---

## 🎯 Descripción

Aplicación de consola que convierte montos entre distintas monedas.  
Está pensada para integrarse con una **API de tipo de cambio** (por ejemplo, ExchangeRate-API) y seguir creciendo como laboratorio de pruebas de Java.

---

## ✅ Funcionalidades

- Solicita al usuario:
  - monto a convertir
  - moneda de origen
  - moneda de destino
- Obtiene la tasa de cambio desde un componente dedicado (cliente de API).
- Calcula el resultado y lo muestra de forma clara en consola.
- Maneja errores básicos de entrada (opciones inválidas, formato numérico, etc.).

---

## 🧩 Arquitectura (versión de estudio)

Estructura sugerida del proyecto:

- `Main.java`
  - Punto de entrada.
  - Orquesta el flujo: menú → lectura de datos → llamada al conversor → salida en consola.
- `ExchangeRateClient.java`
  - Encapsula la lógica de obtener la tasa de cambio.
  - Preparado para consumir una API externa de tipo de cambio.
- `CurrencyConverter.java`
  - Contiene la lógica de negocio de conversión.
  - Recibe monto + tasa y devuelve el resultado.
- `model/` *(opcional)*
  - Clases simples para representar monedas, respuestas de API, etc.

Esta separación ayuda a practicar **encapsulación, responsabilidad única y acoplamiento bajo**, objetivos clave de ONE G9.

---

## 🛠️ Tecnologías

- Java 17+ (recomendado)
- IDE: IntelliJ IDEA (o similar)
- Dependencias:
  - `java.net.http` o librería HTTP equivalente (para la API de tipos de cambio)
  - `com.google.gson` u otra librería JSON (si se parsea la respuesta de la API)

---

## ▶️ Cómo ejecutar el proyecto

1. Clonar el repositorio:

   ```bash
   git clone https://github.com/IAJujuy/Conversor_de_Monedas.git
   cd Conversor_de_Monedas
