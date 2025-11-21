Console 1

cd ~/DevOpsTask
docker compose down -v --remove-orphans 2>/dev/null || true
docker compose up --build

Console 2

cd ~/DevOpsTask
docker compose ps

curl http://localhost:8080/greeting?name=Kacper

curl http://localhost:8080/greeting?name=Test1
curl http://localhost:8080/greeting?name=Test2


docker exec devopstask-mysql-1 mysql -u root -psecret -N -e "SELECT id, content FROM greetings_db.greetings ORDER BY id;"

#TRWAŁOŚĆ DANYCH
docker compose down
docker compose up -d

docker exec devopstask-mysql-1 mysql -u root -psecret -N -e "SELECT id, content FROM greetings_db.greetings ORDER BY id;"

curl http://localhost:8080/greeting?name=PoRestarcie
