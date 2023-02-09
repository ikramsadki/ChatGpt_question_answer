# ChatGpt_question_answer
communicate with ChatGPT AI via a call to an endpoint that we will expose.
# chatgpt-service 
Ce code fait partie d’une application Spring Boot basée sur Java qui fournit une API REST pour interagir avec l’API OpenAI.
# ChatGptConfig
La classe ChatGptConfig définit diverses valeurs constantes qui sont utilisées tout au long de l’application. Par exemple, AUTHORIZATION est utilisé pour spécifier l’en-tête d’autorisation dans les requêtes API, API_KEY est utilisé pour stocker la clé API, et URL est utilisé pour spécifier l’URL du endpoint de l’API OpenAI.
#  BotController
La classe BotController est un contrôleur REST qui mappe les requêtes HTTP entrantes aux méthodes qui renvoient des objets ChatGptResponse. La méthode sendMessage prend un objet BotRequest en entrée, qui contient la question d’un utilisateur, et retourne un objet ChatGptResponse qui contient la réponse générée par l’API OpenAI.
#  BotService
 La classe BotService est utilisée pour faire des appels API vers l’API OpenAI et renvoyer la réponse au contrôleur.
 # CsvController
 La classe CsvController est un autre contrôleur REST qui mappe les requêtes HTTP entrantes aux méthodes de conversion des données JSON en CSV. La méthode jsonToCsv prend une liste de cartes en entrée et crée un fichier CSV avec les données.
 # BotRequest
 La classe BotRequest est un objet de données simple qui contient la question d’un utilisateur.
 # ChatGptRequest
  La classe ChatGptRequest est utilisée pour faire des requêtes API vers l’API OpenAI et contient des informations telles que le modèle à utiliser, l’invite et le nombre maximum de jetons à générer.
#  ChatGptResponse
La classe ChatGptResponse est un objet de données qui contient la réponse générée par l’API OpenAI. Les champs id et object contiennent des informations sur la réponse, le champ model contient des informations sur le model utilisé.
# choices
le champ choices contient une liste d’objets Choice, dont chacun contient une réponse générée et son score.

# Pour exécuter ce projet, vous aurez besoin de :

JDK 17 ou supérieur
Maven 3.0 ou supérieur

# pour tester POSTMAN
-Créez une nouvelle requête : Cliquez sur le bouton "Nouvelle" pour créer une nouvelle requête.
-Choisissez le type de requête que vous souhaitez envoyer dans notre cas POST
-Entrez l'URL de l'API : Entrez l'URL complète de l'API que vous souhaitez tester.
      http://localhost:8090/api/chat/ikram/send   avec POST 
-Ajoutez  line sous format json :
         {
    "question": "define chatgpt?"
}
-Envoyez la requête : Cliquez sur le bouton "Send" pour envoyer la requête à l'API.
- la reponse sous format json 
     {
    "id": "cmpl-6hpV9zIDe6RnL4OQDwYA126KkcfZc",
    "object": "text_completion",
    "model": "text-davinci-003",
    "created": "+4590439-07-26",
    "choices": [
        {
            "index": 0,
            "text": "\n\nChatGPT is a natural language processing (NLP) model developed by OpenAI. It is a transformer-based language model that is trained on a large corpus of conversational data. It is designed to generate human-like responses to user input, allowing for natural conversations between humans and machines.",
            "finish_reason": "stop"
        }
    ]
}
# pour ajouter la question et la reponse dans un fichier json meme etape 

Entrez l'URL de l'API : Entrez l'URL complète de l'API que vous souhaitez tester.
                http://localhost:8090/json-to-csv   avec POST 
-Ajoutez  line sous format json :

     [  {    "message": "why chatgpt?"}]
-reponse 
      CSV file created successfully!

# il faut changer API_KEY par votre propre API KEY
# dans append.csv on trouve la ligne est ajoutee
