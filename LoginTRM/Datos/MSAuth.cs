using System.Text;
using LoginTRM.Models;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;

namespace LoginTRM.Datos;

public class MSAuth
{
    public async Task<List<TokenRespuesta>> IniciarSesion(Usuario usuario)
    {
        List<TokenRespuesta> respuesta = new List<TokenRespuesta>();
        Cadenas cadenas = new Cadenas();
        try{
            var json = JsonConvert.SerializeObject(usuario);
            using var client = new HttpClient();
            //client.DefaultRequestHeaders.Add("Authorization", jwt);
            var url = cadenas.msAuth + "/iniciarSesion";
            var content = new StringContent(json, Encoding.UTF8, "application/json");
            var respClient = await client.PostAsync(url, content);

            if(respClient.IsSuccessStatusCode)
            {
                var responseBody = await respClient.Content.ReadAsStringAsync();
                var jsonObject = JsonConvert.DeserializeObject<JObject>(responseBody);

                    TokenRespuesta tokenRespuesta = new TokenRespuesta();
                    tokenRespuesta.successfull = bool.Parse(jsonObject["successfull"].ToString());
                    tokenRespuesta.token = jsonObject["token"].ToString();
                    tokenRespuesta.respuesta = jsonObject["respuesta"].ToString();
                    tokenRespuesta.usuario = jsonObject["usuario"].ToString();
                    tokenRespuesta.idUsuario = jsonObject["idUsuario"].ToString();
                    respuesta.Add(tokenRespuesta);
            }
            else{
                TokenRespuesta tokenRespuesta = new TokenRespuesta();
                tokenRespuesta.successfull = false;
                tokenRespuesta.respuesta = "Error de httpclient";
                respuesta.Add(tokenRespuesta);
            }

        }catch(Exception ex){
                TokenRespuesta tokenRespuesta = new TokenRespuesta();
                tokenRespuesta.successfull = false;
                tokenRespuesta.respuesta = "Error: " + ex.ToString();
                respuesta.Add(tokenRespuesta);
        }

        return respuesta;
    }
}

