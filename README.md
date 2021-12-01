# registrationDemo
Curl para a geração do BearerToken:

curl --request POST \
  --url 'https://dev-lb636fcx.us.auth0.com/oauth/token' \
  --header 'content-type: application/x-www-form-urlencoded' \
  --data grant_type=client_credentials \
  --data client_id=YqWZKwpdbtrIOv31CKjU5FwMG2mWVHCa \
  --data client_secret=qsYpdCiqbu7t5SA0K2nEhJVGDoKKSF7JdCcLF81Jouoq560bsnk8Iak9MgCd9cSu \
  --data audience=https://registercustomerdemo.com
  
  Serviço disponivel no Heroku:
  https://infinite-sea-92349.herokuapp.com/isAlive


