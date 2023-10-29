using System.Text;
using LoginTRM.Models;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;

namespace LoginTRM.Datos;

public class MSTrm
{
    public async Task<List<MonedaRespuesta>> Moneda(Moneda moneda, string jwt)
    {
        List<MonedaRespuesta> respuesta = new List<MonedaRespuesta>();
        Cadenas cadenas = new Cadenas();
        try{
            var json = JsonConvert.SerializeObject(moneda);
            using var client = new HttpClient();
            client.DefaultRequestHeaders.Add("Authorization", jwt);
            var url = cadenas.msTrm + "/moneda";
            var content = new StringContent(json, Encoding.UTF8, "application/json");
            var respClient = await client.PostAsync(url, content);

            if(respClient.IsSuccessStatusCode)
            {
                var responseBody = await respClient.Content.ReadAsStringAsync();
                var jsonObject = JsonConvert.DeserializeObject<JObject>(responseBody);

                MonedaRespuesta monedaRespuesta = new MonedaRespuesta();
                    monedaRespuesta.successfull = bool.Parse(jsonObject["successfull"].ToString());
                    monedaRespuesta.respuesta = jsonObject["respuesta"].ToString();
                    monedaRespuesta.cantidad = double.Parse(jsonObject["cantidad"].ToString());
                    monedaRespuesta.resultado = double.Parse(jsonObject["resultado"].ToString());
                    respuesta.Add(monedaRespuesta);
            }
            else{
                MonedaRespuesta monedaRespuesta = new MonedaRespuesta();
                monedaRespuesta.successfull = false;
                monedaRespuesta.respuesta = "Error de httpclient";
                respuesta.Add(monedaRespuesta);
            }

        }catch(Exception ex){
                MonedaRespuesta monedaRespuesta = new MonedaRespuesta();
                monedaRespuesta.successfull = false;
                monedaRespuesta.respuesta = "Error: " + ex.ToString();
                respuesta.Add(monedaRespuesta);
        }

        return respuesta;
    }
}