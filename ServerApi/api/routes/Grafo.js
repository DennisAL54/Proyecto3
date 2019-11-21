const express = require('express');
const router = express.Router();

router.get('/', (req, res, next) => {
	res.status(200).json ({
	    message: 'Obteniendo'
	});
});

router.post('/', (req, res, next) => {
	res.status(200).json ({
	    message: 'Posteando'
	});
});

router.get('/:GraphId', (req, res, next)=> {
    res.status(200).json()({
        message:'Detalles del grafo',
        GraphId: req.params.GraphId
    })
})
router.delete('/GraphId', (req, res, next)=> {
    res.status(200).json()({
        message:'Grafo Borrado',
        GraphId: req.params.GraphId
    })
})
module.exports = router;
