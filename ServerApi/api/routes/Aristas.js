const express = require('express');
const router = express.Router();

router.get('/', (req, res, next)=> {
    res.status(200).json()({
        message:'Arista obtenida'
    })
})
router.post('/', (req, res, next) => {
	res.status(201).json ({
	    message: 'Arista creada'
	});
});

router.get('/:EdgeId', (req, res, next)=> {
    res.status(200).json()({
        message:'Detalles de la arista',
        EdgeId: req.params.EdgeId
    })
})
router.delete('/:EdgeId', (req, res, next)=> {
    res.status(200).json()({
        message:'Arista Borrada',
        EdgeId: req.params.EdgeId
    })
})





module.exports = router;