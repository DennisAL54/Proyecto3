const express = require('express');// importamos express

const app = express()// lo usamos
const port = 3000 // asignamos un puerto

app.use(express.json())// lo aplicamos a un app

app.post('/graphs', (req,res)=> { // post request para crear un grafo
    res.send('Grafo Posteado')
})

app.get('/graphs', (req, res)=> {//get request para obtener un grafo
    res.send('Grafo Obtenido')
})

app.delete('/graphs', (req,res)=> {// delete request para borrar un grafo
    res.send('Grafos Borrados')
})

app.get('/graphs/:graphid/degree',(req,res)=> {//get request para obtener el grado del grafo
    const id = req.params.graphid;
    res.send("Grado del grafo con id: " + id)
})

app.get('/graphs/:graphid/dijkstra',(req,res)=> {//get request para obtener el camino mas corto
    const id = req.params.graphid;
    res.send("Algoritmo dijkstra aplicado al grafo con id: " + id)
})

app.get('/graphs/:graphid',(req,res)=> {//get request para acceder a un grafo específico
    const id = req.params.graphid;
    res.send("Accedió al grafo con id: " + id)
})
app.delete('/graphs/:graphid', (req,res)=> {// delete request para borrar un grafo específico
    const id = req.params.graphid
    res.send('El grafo con el id ' + id + ' fue borrado')
})
app.post('/graphs/:graphid/nodes', (req,res)=> {// post request para crear un nodo
    const id = req.params.graphid
    res.send('Nodo creado en el grafo id: ' + id)
})
app.get('/graphs/:graphid/nodes',(req,res)=> {//get request para retornar los nodos de un grafo
    const id = req.params.graphid;
    res.send("Nodos del grafo con id: " + id)
})
app.put('/graphs/:graphid/nodes/:nodeid',(req,res)=> {//put request para actualizar un nodo 
    const id = req.params.graphid;
    const id2 = req.params.nodeid;
    res.send('Nodo ' + id2 +  ' del grafo con id: ' + id + ' actualizado')
})

app.delete('/graphs/:graphid/nodes/:nodeid',(req,res)=> { // delete request para borrar un nodo en específico
    const id = req.params.graphid;
    const id2 = req.params.nodeid;
    res.send('Nodo ' + id2 +  ' del grafo con id: ' + id + ' eliminado')
})
app.delete('/graphs/:graphid/nodes',(req,res)=> {// delete request para borrar todos los nodos
    const id = req.params.graphid;
    res.send('Nodos del grafo identificado con id: ' + id + ' eliminados')
})
app.get('/graphs/:graphid/edges',(req,res)=> {// get request para obtener todas las aristas de un grafo
    const id = req.params.graphid;
    res.send("Aristas del grafo con id: " + id)
})
app.delete('/graphs/:graphid/edges',(req,res)=> { // delete request para borrar las aristas de un grafo
    const id = req.params.graphid;
    res.send("Aristas del grafo con id: " + id + ' Eliminadas')
})

app.post('/graphs/:graphid/edges',(req,res)=> {// post request para crear una arista en un grafo
    const id = req.params.graphid;
    res.send("Arista creada en el grafo con id: " + id)
})
app.put('/graphs/:graphid/edges/:edgeid',(req,res)=> {// put request para actualizar las aristas de un grafo
    const id = req.params.graphid;
    const id2 = req.params.edgeid;
    res.send('Arista con id: ' + id2 +  ' del grafo con id: ' + id + ' actualizada')
})
app.delete('/graphs/:graphid/edges/:edgeid',(req,res)=> {// delete request para eliminar una arista especifica de un grafo
    const id = req.params.graphid;
    const id2 = req.params.edgeid;
    res.send('Arista con id: ' + id2 +  ' del grafo con id: ' + id + ' eliminada')
})

app.listen(port, ()=>{
    console.log('app running')
})