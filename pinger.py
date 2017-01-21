import time
import sys

import requests


def main():
    URL = 'http://soroush-webbsidan.rhcloud.com/'

    while True:
        try:
            print('Pinging')
            requests.get(URL)
            time.sleep(10 * 1)
        except KeyboardInterrupt:
            print('\nExiting')
            sys.exit(0)

if __name__ == '__main__':
    main()
