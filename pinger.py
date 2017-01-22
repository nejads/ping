import time
import sys

import requests


def main():
    URL = 'http://soroush-webbsidan.rhcloud.com/'

    while True:
        try:
            print('Pinging from python')
            requests.get(URL)
            time.sleep(60 * 15)
        except KeyboardInterrupt:
            print('\nExiting')
            sys.exit(0)

if __name__ == '__main__':
    main()
