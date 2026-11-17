# Calculadora

APP Android (Java) de la Actividad 5, Módulo 3 – parte grupal.
Calculadora con suma, resta, multiplicación y división, historial de operaciones y botón para salir.

## Qué usa del módulo

| Tema | Dónde está |
| --- | --- |
| Tipos de paneles | `LinearLayout` (pantalla) + `TableLayout` (botones) + `ScrollView` (historial) |
| Componentes básicos | `Button`, `TextView`, `EditText` |
| Escribir y manipular texto | `setText()`, `append()`, `setTextColor()` desde Java |
| Eventos y listeners | `View.OnClickListener` compartido y `View.OnKeyListener` en el segundo cuadro |
| Mensajes emergentes | `Toast` para validaciones y división entre cero |

## Reparto por integrante

| Integrante | Operación | Método en `MainActivity.java` | Mensaje de commit |
| --- | --- | --- | --- |
| Integrante 1 | Suma y resta (base del proyecto) | `sumar()`, `restar()` | `feat: estructura base, suma y resta` |
| Integrante 2 | Multiplicación | `multiplicar()` | `feat: operación multiplicación` |
| Integrante 3 | División con validación de cero | `dividir()` | `feat: operación división con validación` |

Para que el historial de GitHub muestre a cada autor con su operación:

1. El integrante 1 sube el proyecto dejando `multiplicar()` y `dividir()` con `return 0;`.
2. Los integrantes 2 y 3 clonan el repositorio, escriben su método (`return a * b;` y `return a / b;`) y hacen push.

```bash
# Integrante 1
git init -b main
git add .
git commit -m "feat: estructura base, suma y resta"
git remote add origin https://github.com/MarcelDeulofeuth19/Calculadora.git
git push -u origin main

# Integrantes 2 y 3
git clone https://github.com/MarcelDeulofeuth19/Calculadora.git
# ... completar su método en MainActivity.java ...
git add app/src/main/java/com/umb/calculadora/MainActivity.java
git commit -m "feat: operación multiplicación"
git pull --rebase origin main
git push
```

En GitHub: Settings → Collaborators → agregar a los dos compañeros y al docente.

## Cómo ejecutarla

1. Android Studio → File → Open → carpeta `Calculadora`.
2. Esperar la sincronización de Gradle.
3. Run ▶ sobre un emulador o un celular (Android 7.0 / API 24 o superior).

Si la sincronización falla por versiones, crear un proyecto nuevo *Empty Views Activity* (Java, minSdk 24, paquete `com.umb.calculadora`) y copiar encima la carpeta `app/src/main`.
