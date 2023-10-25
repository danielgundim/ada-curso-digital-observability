import requests
import threading

# Função que realiza a requisição e imprime o status
def realizar_requisicao():
    while True:
        requisicao = requests.get("http://localhost:8080/api/pessoas")
        print(requisicao.status_code)

# Número de threads que você deseja criar
num_threads = 5  # Você pode ajustar conforme necessário

# Lista para armazenar as threads
threads = []

# Crie e inicie as threads
for _ in range(num_threads):
    thread = threading.Thread(target=realizar_requisicao)
    thread.start()
    threads.append(thread)

# Aguarde que todas as threads terminem (elas estarão em execução eternamente)
for thread in threads:
    thread.join()
