import socket
import RPi.GPIO as GPIO


#Definicion de GPIO
GPIO.setwarnings(False)
GPIO.setmode(GPIO.BOARD)
GPIO.setup(5,GPIO.OUT)
GPIO.setup(3,GPIO.OUT)
GPIO.setup(13,GPIO.OUT)
GPIO.setup(12,GPIO.OUT)
GPIO.setup(16,GPIO.OUT)
GPIO.setup(19,GPIO.OUT)
GPIO.setup(22,GPIO.OUT)
GPIO.setup(23,GPIO.OUT)
GPIO.setup(26,GPIO.OUT)
GPIO.setup(29,GPIO.OUT)

#Variable socket
mysoc=socket.socket()
mysoc.bind(("IP Raspberry Pi",5000))
mysoc.listen(5)

#proceso
while 1:
    conn,addr=mysoc.accept()
    data=conn.recv(64)
    d=str(data)[2:3]
    print(d)
    
#Luz del patio
    if d=="e":
        print('Luz de Patio Encendida')
        GPIO.output(5,True)
    elif d=="a":
        print('Luz de Patio Apagada')
        GPIO.output(5,False)
        
#Bomba de agua        
    elif d=="b":
        print('Bomba Encendida')
        GPIO.output(3, True)
    elif d=="t":
        print('Bomba Apagada')
        GPIO.output(3, False)
        
#Alarma
    elif d=="o":
        print('Alarma Encendida')
        GPIO.output(13, True)
    elif d=="f":
        print('Alarma Apagada')
        GPIO.output(13, False)
        
#Ventilador
    elif d=="v":
        print('Ventilador Encendido')
        GPIO.output(12, True)
    elif d=="c":
        print('Ventilador Apagado')
        GPIO.output(12, False)
        
#Secadora
    elif d=="s":
        print('Secadora ON')
        GPIO.output(16, True)
    elif d=="d":
        print('Secadora OFF')
        GPIO.output(16, False)
        
#Luz Sala
    elif d=="u":
        print('Luz Sala Encendida')
        GPIO.output(19, True)
    elif d=="g":
        print('Luz Sala Apagada')
        GPIO.output(19, False)
        
#Luz Habitacion 1
    elif d=="h":
        print('Luz Habitacion 1 Encendida')
        GPIO.output(22, True)
    elif d=="i":
        print('Luz Habitacion 1 Apagada')
        GPIO.output(22, False)
        
#Luz Habitacion 2
    elif d=="j":
        print('Luz Habitacion 2 Encendida')
        GPIO.output(23, True)
    elif d=="k":
        print('Luz Habitacion 2 Apagada')
        GPIO.output(23, False)
        
#Luz Cocina
    elif d=="l":
        print('Luz Cocina Encendida')
        GPIO.output(26, True)
    elif d=="m":
        print('Luz Cocina Apagada')
        GPIO.output(26, False)
        
#Luz Baño
    elif d=="n":
        print('Luz Baño Encendida')
        GPIO.output(29, True)
    elif d=="p":
        print('Luz Baño Apagada')
        GPIO.output(29, False)
    conn.close()
       
mysoc.close() 