#!/bin/bash

# Определяем конфигурации для разных тестовых классов
declare -A TEST_CONFIGS=(
  ["Components_Test"]="fullscreen"
  ["Login_Test"]="fullscreen"
  ["Registration_Test"]="fullscreen"
  ["Wishlists_Test"]="fullscreen"
  ["WishlistUsers_Test"]="fullscreen"
)

# Базовые параметры
BASE_URL="https://wishlist.otus.kartushin.su"
REMOTE_URL="http://193.104.57.173/wd/hub"
BROWSER="firefox"
VERSION="125.0"

# Функция запуска тестов с параметрами
run_test_class() {
  local test_class=$1
  local launch_param=$2

  echo "--------------------------------------------------"
  echo "Запуск тестового класса: $test_class"
  echo "Параметр запуска: $launch_param"
  echo "--------------------------------------------------"

  mvn test \
    -Dbrowser="$BROWSER" \
    -Dlaunch-parameter="$launch_param" \
    -Dbrowser-version="$VERSION" \
    -Dbase-url="$BASE_URL" \
    -Dremote-url="$REMOTE_URL" \
    -Dtest="$test_class"
}

# Основной цикл запуска
for test_class in "${!TEST_CONFIGS[@]}"; do
  launch_param="${TEST_CONFIGS[$test_class]}"

# Запускаем в фоновом режиме для параллельного выполнения
  run_test_class "$test_class" "$launch_param" &
done

# Ждем завершения всех тестов
wait

echo "Все тесты завершены"

# Генерируем отчет Allure
allure serve allure-results/