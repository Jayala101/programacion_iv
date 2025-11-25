# 🚀 Guía de Instalación y Ejecución

## Vuelos Aeropuerto - React Native App

### 📋 Paso 1: Instalar dependencias

Abre PowerShell en el directorio del proyecto y ejecuta:

```powershell
cd C:\Programacion_IV\modulo_2\react_native\vuelos-aeropuerto
npm install
```

### 📱 Paso 2: Iniciar el proyecto

```powershell
npm start
```

Esto abrirá Expo Dev Tools en tu navegador.

### 🔧 Opciones de ejecución

#### Opción 1: En Android (Recomendado)
1. Asegúrate de tener un emulador Android corriendo o un dispositivo físico conectado
2. Presiona `a` en la terminal o haz clic en "Run on Android device/emulator" en Expo Dev Tools

```powershell
npm run android
```

#### Opción 2: En iOS (Solo macOS)
```powershell
npm run ios
```

#### Opción 3: En Web
```powershell
npm run web
```

#### Opción 4: Expo Go (Dispositivo físico)
1. Instala "Expo Go" desde Play Store o App Store
2. Escanea el código QR que aparece en la terminal
3. La app se cargará en tu dispositivo

### ⚡ Solución de problemas

Si encuentras errores durante la instalación:

```powershell
# Limpiar caché de npm
npm cache clean --force

# Eliminar node_modules y reinstalar
Remove-Item -Recurse -Force node_modules
npm install

# Si hay problemas con Expo
npm install -g expo-cli
```

### 📂 Estructura del proyecto

```
vuelos-aeropuerto/
├── src/
│   ├── components/      # Componentes reutilizables
│   ├── context/         # Context API
│   ├── navigation/      # Configuración de navegación
│   ├── screens/         # Pantallas de la app
│   ├── theme/          # Colores y estilos
│   └── types/          # Tipos TypeScript
├── App.tsx             # Componente principal
├── package.json        # Dependencias
└── README.md          # Documentación
```

### ✨ Características implementadas

- ✅ Navegación con tabs inferior
- ✅ Lista de vuelos de salida
- ✅ Lista de vuelos de llegada
- ✅ Búsqueda de vuelos
- ✅ Información del aeropuerto
- ✅ Modal de detalles de vuelo
- ✅ Estados de vuelo con colores
- ✅ Diseño moderno con gradientes
- ✅ TypeScript para type safety
- ✅ Context API para gestión de estado

### 🎨 Tecnologías

- React Native
- Expo SDK 54
- TypeScript
- React Navigation v7
- Expo Linear Gradient
- Context API

### 📞 Soporte

Si tienes problemas, verifica:
1. Node.js está instalado (versión 16 o superior)
2. npm está actualizado
3. Expo CLI está instalado globalmente
4. El emulador Android está corriendo (si usas Android)

¡Disfruta tu aplicación de vuelos! ✈️
