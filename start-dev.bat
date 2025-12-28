@echo off
echo 🚀 Iniciando Twitter Clone en modo desarrollo...

echo 📀 Iniciando base de datos...
docker-compose -f docker-compose.dev.yml up -d

echo ⏳ Esperando que MySQL esté listo...
timeout /t 10

echo ⚙️ Iniciando backend...
start /d backend mvnw.cmd spring-boot:run

echo ⏳ Esperando que el backend esté listo...
timeout /t 15

echo 🎨 Iniciando frontend...
start /d frontend npm run dev

echo ✅ Aplicación iniciada:
echo    Backend: http://localhost:8081
echo    Frontend: http://localhost:3000
echo    Base de datos: http://localhost:8080 (Adminer)

pause