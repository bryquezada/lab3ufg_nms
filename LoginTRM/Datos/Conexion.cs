namespace LoginTRM.Datos;

public class Conexion
{}

public class Cadenas{
    private static IConfiguration builder = new ConfigurationBuilder().SetBasePath(Directory.GetCurrentDirectory()).AddJsonFile("appsettings.json").Build();

    public string msAuth = builder.GetSection("MSCadenas:MSmimicroauth").Value;
    public string msTrm = builder.GetSection("MSCadenas:MSmimicrotrm").Value;
    
}