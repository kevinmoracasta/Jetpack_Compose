# Documentación MyApp JetpackCompose

#En esta actividad aprendí una variedad de cosas como las el cómo hacer que las funciones admitan composiciones usando el compensable, también el preview que es más que todo como un tipo de vista previa,

@Preview(showBackground = true)

@Composable
fun PreviewMessageCard() {

    MyApp2687386Theme {
    
        Surface {
        
            MessageCard(Message("kevin","Es la vida  "))
            
        }
        
    }  



#para ver en si lo que se va haciendo en el proyecto, entre ello también aprendí como aplicar diseño tanto a la imagen como al texto al mismo tiempo aprendí a colocar una imagen

@Composable

fun MessageCard(msg: Message) {

    Row (modifier = Modifier.padding(all = 8.dp)){
    
        Image(painter = painterResource(id = R.drawable.descarga__1_), contentDescription = "contact profile picture",modifier = Modifier
        
            .size(40.dp)
            
            .clip(CircleShape)
            
        )
        
        Spacer(modifier = Modifier.width(1.dp))
        
        var isExpanded by remember {mutableStateOf(false)}
        
        Surface(){
        
        }

        Column (modifier = Modifier.clickable { isExpanded = !isExpanded }){
        
            Text(
            
            text = msg.author,
            
            color = MaterialTheme.colorScheme.secondary,style= MaterialTheme.typography.titleSmall
            
            )
            Surface(shape = MaterialTheme.shapes.large, shadowElevation = 1.dp) {
            
                Text(
                
                    text = msg.body,
                    
                    modifier = Modifier.padding(all = 4.dp),
                    
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    
                    style = MaterialTheme.typography.bodySmall)
                    
            }
        }
    }
}


otra de las cosas que aprendí es que funciona más que todo por capas o sea una sobre la otra, así que si realizo varios textos o varias imágenes estas se copilaran en una sobre la otra así que por eso se usa el column también aprendí sobre marial desing ya para finalizar aprendí como hacer una lista de mensajes

package co.edu.sena.myapp2687386

object SampleData {

    // Sample conversation data
    
    val conversationSample = listOf(
    
        Message(
        
            "Kevin",
            
            "Test...Test...Test..."
            
        ),
        Message(
        
            "Kevin",
            
            "List of Android versions:\n" +
                    "Android KitKat (API 19)\n" +
                    "Android Lollipop (API 21)\n" +
                    "Android Marshmallow (API 23)\n" +
                    "Android Nougat (API 24)\n" +
                    "Android Oreo (API 26)\n" +
                    "Android Pie (API 28)\n" +
                    "Android 10 (API 29)\n" +
                    "Android 11 (API 30)\n" +
                    "Android 12 (API 31)\n"
        ),
        Message(
        
            "Kevin",
            
            "I think Kotlin is my favorite programming language.\n" +
                    "It's so much fun!"
        )

#y el cómo aplicar animaciones a los mensajes al pulsar sobre ellos, por último le edité el color del aro que rodea la imagen que en sí hace la función de imagen de perfil, edite un poco el tamaño del texto y coloque #una imagen propia, la cual tenía guarda tambien el nombre del perfil y el texto de perfil el color del fondo para tener un estilo blanco y negro.

Surface(shape = MaterialTheme.shapes.large, shadowElevation = 1.dp) {

                Text(
                
                    text = msg.body,
                    
                    modifier = Modifier.padding(all = 4.dp),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.bodySmall)
            }
