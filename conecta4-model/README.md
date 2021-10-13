# Conecta 4

Conecta 4 es un juego de mesa para dos **jugadores** en el que se introducen **fichas** por **turnos** en un **tablero** vertical con 6 filas y 7 columnas con el objetivo de alinear cuatro fichas consecutivas de un mismo **color**.

## Version 1 

![plantuml](http://www.plantuml.com/plantuml/png/NO_DIWCn4CVFEqyHUlB35glY8KZ1BaABFNWGUX0FQNQmWTtCacG5ANrtaqbON4-RdVb__2PGBmA90uL0dMYCGnqCMO2QR7og1t4rdw_4cfHh_ircTpFnrgeVT03vM-RBnxWmg160VMLy7_KRQX6cyffQ6XomOJA191R4tjl5OZc6wbPvBqQO4rI7L2CBPTLpkYnm7vzGNNVqZHUNyM7ytbYBBlwSIrAsfPZZW9eaGxAhTyQ6lyh27QLzGf5YPtnuOgmLL9gvPU5F_YYVsFd6KrQEmd7FnNbDhZ5MXTYmjG6_yXMbarDY-b7v790hq0vTJcJ0_MRx_dAptZtNht3-1G00)

## Version 2

![plantuml](http://www.plantuml.com/plantuml/png/VLDDYnD143rF_Oec9nLdSLKy31BMDGSNX5sYe20UEZELsOQUwg4_4Cdwt-tghhYp2NX9gj-hVgzIhmDN8MeVqsG1efjLT6hdOdIJ6ep7FXf701yTvLA_LI_QTgskdVR32VOrUJg1LgzNwixgt-WV2LU8LnSNbolrpH0jEQRo8JYBK2nKc-O51bMCKL5dKq75ylBTAlTRbpoml7G_h8-3L65fVfCbFXLb_dmocsX0RtK8wj-81sXsBD393fgvo7OY_-DdHPuzXpzojpRonVk4lUkAOUdpXc9kREOKxmpsoFM8CJkdYUImTRzOIwGg9OTCIVKXz4Y3eN5ZzEX8My4tU4O8yzaGvebCEFumDbckXXiWEwZMuZws3uBK0Kx0CtjPUMKt-5zQ9Yf9IYbn7-0wxVVeSTYY7dZ7koTdyFcBDVBiNDvGlA6jff61ibnBnsgnGtbqSggnSJepHn2wF5M8xslwQsX8JzYfBp6BZD3q1UvKfJaWIMuHTtb91-vrVZ2aOxwVHyDHNWVtT-fsZePtyUXqhqEjgnXIciI7rMvVVcSKu0ffuB_gNm00)

Refactoring 

 * clase Conecta4App (main) no es necesaria
 * clase Piece es perezosa Piece > Color
 * Eliminar GOTO (break en bucles) > uso do..while
 * Uso de assert > Diseño x Contrato
 * No repetir linea > DRY
 * isWinner > funciones de primer orden
 * Rehacer modelo . meter columna / Turno / Uso de coordinate
 * enum Colour NULL ? 
 * validaciones
 * cambiar jugadores (seguir jugando y cambiar jugadores)
