package com.starlight.stockmoex.parser

import com.starlight.stockmoex.model.Stock
import org.springframework.stereotype.Component
import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import org.xml.sax.InputSource

import javax.xml.parsers.DocumentBuilderFactory

@Component
class StockMoexXmlParser implements Parser {

    @Override
    List<Stock> parse(String stockXmlList) {
        List<Stock> stockList = new ArrayList<>()

        def documentBuilderFactory = DocumentBuilderFactory.newInstance()
        def documentBuilder = documentBuilderFactory.newDocumentBuilder()

        def reader = new StringReader(stockXmlList)
        Document doc = documentBuilder.parse(new InputSource(reader))
        doc.getDocumentElement().normalize()

        NodeList nodeList = doc.getElementsByTagName("row")

        for (i in 0..< nodeList.getLength()) {
            def node = nodeList.item(i)

            if (node.getNodeType() == Node.ELEMENT_NODE) {

                def element = (Element) node
                String secid =  element.getAttribute("SECID")
                String boardid =  element.getAttribute("BOARDID")
                String prevprice = element.getAttribute("PREVPRICE")
                String shortname = element.getAttribute("SHORTNAME")
                String prevdate = element.getAttribute("PREVDATE")

                if(!secid.isEmpty() && !prevprice.isEmpty() && !shortname.isEmpty()) {
                    def stock = Stock.builder()
                            .id(secid)
                            .boardid(boardid)
                            .price(Double.parseDouble(prevprice))
                            .name(shortname)
                            .date(prevdate)
                            .build()

                    stockList.add(stock)
                }
            }
        }

        return stockList;
    }
}

