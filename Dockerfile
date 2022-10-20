FROM openjdk:11

COPY out/production/HotelManager/Main.class /var/www

WORKDIR /var/www

CMD java com.jetbrains.Main

