namespace LoginTRM.Models;

public class LoginModelos
{}

public class Usuario{
    public string? usuario { get; set; }
    public string? contrasenya { get; set; }
}

public class TokenRespuesta{
    public string? token { get; set; }
    public string? idUsuario{ get; set; }
    public string? usuario{ get; set; }
    public string? respuesta{ get; set; }

    public bool? successfull{ get; set; }


}


