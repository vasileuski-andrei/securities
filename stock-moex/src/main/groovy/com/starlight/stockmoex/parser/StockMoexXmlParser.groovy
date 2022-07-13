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
                String date = element.getAttribute("SYSTIME")
                String updateTime = element.getAttribute("ISSUECAPITALIZATION_UPDATETIME")
                String open = element.getAttribute("OPEN")
                String low = element.getAttribute("LOW")
                String high = element.getAttribute("HIGH")
                String last = element.getAttribute("LAST")

                if(!secid.isEmpty() && !open.isEmpty() && !last.isEmpty()) {
                    def stock = Stock.builder()
                            .id(secid)
                            .boardid(boardid)
                            .date(date)
                            .updateTime(updateTime)
                            .open(open as Double)
                            .low(low as Double)
                            .high(high as Double)
                            .last(last as Double)
                            .build()

                    stockList.add(stock)
                }

            }
        }

        return stockList;
    }
}

