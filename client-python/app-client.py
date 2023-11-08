import requests
import threading
import os


endpoint = os.environ.get("ENDPOINT")


def realizar_requisicao():
    while True:
        # http://localhost:8080/api/pessoas
        requisicao = requests.get(endpoint)
        print(endpoint)
        print(requisicao.status_code)


num_threads = 5

threads = []

for _ in range(num_threads):
    thread = threading.Thread(target=realizar_requisicao)
    thread.start()
    threads.append(thread)

for thread in threads:
    thread.join()
