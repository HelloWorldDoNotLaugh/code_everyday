
-- MySQL dump 10.13  Distrib 8.1.0, for macos12.6 (x86_64)
--
-- Host: 10.57.31.147    Database: init_224_2308_spartan_account
-- ------------------------------------------------------
-- Server version	5.7.23-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account_check_config`
--

DROP TABLE IF EXISTS `account_check_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_check_config` (
                                        `uuid` varchar(64) NOT NULL COMMENT 'uuid',
                                        `cust_type` tinyint(4) DEFAULT NULL COMMENT '账户类型 1-对私 2-对公',
                                        `work_flow_code` varchar(64) DEFAULT NULL COMMENT '核查流代码',
                                        `open_flag` tinyint(4) DEFAULT NULL COMMENT '核查开关 0-关闭 1-打开',
                                        `work_config` text COMMENT '认定配置流程json',
                                        `enbance_work_config` text COMMENT '加强认定配置流程json',
                                        `create_by` varchar(36) NOT NULL COMMENT '创建人',
                                        `modify_by` varchar(36) NOT NULL COMMENT '修改人',
                                        `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                        `gmt_modify` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                                        PRIMARY KEY (`uuid`) USING BTREE,
                                        UNIQUE KEY `uk_work_flow_code` (`work_flow_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='账户核查配置表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_check_config`
--

INSERT INTO `account_check_config` (`uuid`, `cust_type`, `work_flow_code`, `open_flag`, `work_config`, `enbance_work_config`, `create_by`, `modify_by`, `gmt_create`, `gmt_modify`) VALUES ('763067a4e3e511edb38afa6532887f00',1,'IIIPPPOO001',1,'{\"code\":\"IIIPPPOO001\",\"version\":1,\"id\":\"ef6dced894924496bd30d3c17b1abeec\",\"name\":\"qd_hb\",\"flowNodeDefinitions\":[{\"x\":150,\"y\":223,\"id\":\"a8eedfa0185411ed9b12edb5f03c3f54\",\"name\":\"开始\",\"nodeType\":\"StartFlowNode\",\"attributes\":{},\"incomingFields\":[],\"outgoingFields\":[]},{\"x\":423,\"y\":209,\"id\":\"8bc0c630281e11ed885081c62d61fab8\",\"name\":\"判断开始\",\"nodeType\":\"ExclusiveGateway\",\"attributes\":{\"type\":\"start\"},\"incomingFields\":[],\"outgoingFields\":[]},{\"x\":599,\"y\":223,\"id\":\"cbfd39e0293111edbf8ec53cea9dcec6\",\"name\":\"保持原评级结果\",\"nodeType\":\"RateResultFlowNode\",\"attributes\":{\"ratingType\":2,\"nodeName\":\"保持原评级结果\"},\"incomingFields\":[],\"outgoingFields\":[]},{\"x\":770,\"y\":212,\"id\":\"cf50d1b0293111edbf8ec53cea9dcec6\",\"name\":\"结束\",\"nodeType\":\"EndFlowNode\",\"attributes\":{},\"incomingFields\":[],\"outgoingFields\":[]},{\"x\":397,\"y\":385,\"id\":\"502877d029cc11ed9c7b3b870238731b\",\"name\":\"加入尽职调查\",\"nodeType\":\"RateResultFlowNode\",\"attributes\":{\"ratingType\":3,\"nodeName\":\"加入尽职调查\"},\"incomingFields\":[],\"outgoingFields\":[]},{\"x\":428,\"y\":491,\"id\":\"a3c30e5029cc11ed9c7b3b870238731b\",\"name\":\"结束\",\"nodeType\":\"EndFlowNode\",\"attributes\":{},\"incomingFields\":[],\"outgoingFields\":[]},{\"x\":397,\"y\":96,\"id\":\"35c1e7b029d011eda2e1dd0d7ed36fc8\",\"name\":\"更新评级结果\",\"nodeType\":\"RateResultFlowNode\",\"attributes\":{\"ratingType\":1,\"nodeName\":\"更新评级结果\"},\"incomingFields\":[],\"outgoingFields\":[]},{\"x\":745,\"y\":68,\"id\":\"4db0c44029d011eda2e1dd0d7ed36fc8\",\"name\":\"结束\",\"nodeType\":\"EndFlowNode\",\"attributes\":{},\"incomingFields\":[],\"outgoingFields\":[]}],\"flowLineDefinitions\":[{\"id\":\"d34d45a0-281e-11ed-8850-81c62d61fab8\",\"fromPoint\":1,\"toPoint\":3,\"attributes\":{},\"sourceNodeId\":\"a8eedfa0185411ed9b12edb5f03c3f54\",\"targetNodeId\":\"8bc0c630281e11ed885081c62d61fab8\"},{\"id\":\"cd635990-2931-11ed-bf8e-c53cea9dcec6\",\"fromPoint\":1,\"toPoint\":3,\"attributes\":{\"conditionName\":\"默认分支\",\"isDefault\":true},\"sourceNodeId\":\"8bc0c630281e11ed885081c62d61fab8\",\"targetNodeId\":\"cbfd39e0293111edbf8ec53cea9dcec6\",\"lineType\":\"ExclusiveConditionLine\",\"name\":\"默认分支\"},{\"id\":\"d06d6540-2931-11ed-bf8e-c53cea9dcec6\",\"fromPoint\":1,\"toPoint\":3,\"attributes\":{},\"sourceNodeId\":\"cbfd39e0293111edbf8ec53cea9dcec6\",\"targetNodeId\":\"cf50d1b0293111edbf8ec53cea9dcec6\"},{\"id\":\"51ba1450-29cc-11ed-9c7b-3b870238731b\",\"fromPoint\":2,\"toPoint\":\"0\",\"attributes\":{\"conditionName\":\"黑名单手机号\",\"priority\":2,\"condition\":\"{\\\"logicOperator\\\":\\\"||\\\",\\\"type\\\":\\\"context\\\",\\\"children\\\":[{\\\"property\\\":\\\"S_S_MOBINO\\\",\\\"op\\\":\\\"==\\\",\\\"value\\\":\\\"18758012120\\\",\\\"propertyDataType\\\":\\\"STRING\\\",\\\"type\\\":\\\"context\\\",\\\"rightValueType\\\":\\\"input\\\",\\\"priority\\\":1},{\\\"property\\\":\\\"S_S_ACCTNO\\\",\\\"op\\\":\\\"==\\\",\\\"value\\\":\\\"6699660116610001965\\\",\\\"propertyDataType\\\":\\\"STRING\\\",\\\"type\\\":\\\"context\\\",\\\"rightValueType\\\":\\\"input\\\",\\\"priority\\\":2},{\\\"property\\\":\\\"S_S_MOBINO\\\",\\\"op\\\":\\\"==\\\",\\\"value\\\":\\\"18758012127\\\",\\\"propertyDataType\\\":\\\"STRING\\\",\\\"type\\\":\\\"context\\\",\\\"rightValueType\\\":\\\"input\\\",\\\"priority\\\":3},{\\\"property\\\":\\\"S_S_MOBINO\\\",\\\"op\\\":\\\"==\\\",\\\"value\\\":\\\"15987393222\\\",\\\"propertyDataType\\\":\\\"STRING\\\",\\\"type\\\":\\\"context\\\",\\\"rightValueType\\\":\\\"input\\\",\\\"priority\\\":4}]}\"},\"sourceNodeId\":\"8bc0c630281e11ed885081c62d61fab8\",\"targetNodeId\":\"502877d029cc11ed9c7b3b870238731b\",\"lineType\":\"ExclusiveConditionLine\",\"name\":\"黑名单手机号\"},{\"id\":\"a53dc770-29cc-11ed-9c7b-3b870238731b\",\"fromPoint\":2,\"toPoint\":\"0\",\"attributes\":{},\"sourceNodeId\":\"502877d029cc11ed9c7b3b870238731b\",\"targetNodeId\":\"a3c30e5029cc11ed9c7b3b870238731b\"},{\"id\":\"37d7f670-29d0-11ed-a2e1-dd0d7ed36fc8\",\"fromPoint\":0,\"toPoint\":\"2\",\"attributes\":{\"conditionName\":\"18720912911\",\"priority\":1,\"condition\":\"{\\\"logicOperator\\\":\\\"||\\\",\\\"type\\\":\\\"context\\\",\\\"children\\\":[{\\\"property\\\":\\\"S_S_MOBINO\\\",\\\"op\\\":\\\"==\\\",\\\"value\\\":\\\"18720912911\\\",\\\"propertyDataType\\\":\\\"STRING\\\",\\\"type\\\":\\\"context\\\",\\\"rightValueType\\\":\\\"input\\\",\\\"priority\\\":1}]}\"},\"sourceNodeId\":\"8bc0c630281e11ed885081c62d61fab8\",\"targetNodeId\":\"35c1e7b029d011eda2e1dd0d7ed36fc8\",\"lineType\":\"ExclusiveConditionLine\",\"name\":\"18720912911\"},{\"id\":\"148a5bb0-301d-11ed-ad18-35c8587fc064\",\"fromPoint\":1,\"toPoint\":\"3\",\"attributes\":{},\"sourceNodeId\":\"35c1e7b029d011eda2e1dd0d7ed36fc8\",\"targetNodeId\":\"4db0c44029d011eda2e1dd0d7ed36fc8\"}]}','{\"code\":\"IIIPPPOO001\",\"flowLineDefinitions\":[{\"attributes\":{},\"fromPoint\":\"1\",\"id\":\"d34d45a0-281e-11ed-8850-81c62d61fab8\",\"sourceNodeId\":\"a8eedfa0185411ed9b12edb5f03c3f54\",\"targetNodeId\":\"8bc0c630281e11ed885081c62d61fab8\",\"toPoint\":\"3\"},{\"attributes\":{\"conditionName\":\"默认分支\",\"isDefault\":true},\"fromPoint\":\"1\",\"id\":\"cd635990-2931-11ed-bf8e-c53cea9dcec6\",\"lineType\":\"ExclusiveConditionLine\",\"name\":\"默认分支\",\"sourceNodeId\":\"8bc0c630281e11ed885081c62d61fab8\",\"targetNodeId\":\"cbfd39e0293111edbf8ec53cea9dcec6\",\"toPoint\":\"3\"},{\"attributes\":{},\"fromPoint\":\"1\",\"id\":\"d06d6540-2931-11ed-bf8e-c53cea9dcec6\",\"sourceNodeId\":\"cbfd39e0293111edbf8ec53cea9dcec6\",\"targetNodeId\":\"cf50d1b0293111edbf8ec53cea9dcec6\",\"toPoint\":\"3\"},{\"attributes\":{\"conditionName\":\"黑名单手机号\",\"priority\":2,\"condition\":\"{\\\"logicOperator\\\":\\\"||\\\",\\\"type\\\":\\\"context\\\",\\\"children\\\":[{\\\"property\\\":\\\"S_S_MOBINO\\\",\\\"op\\\":\\\"==\\\",\\\"value\\\":\\\"18758012120\\\",\\\"propertyDataType\\\":\\\"STRING\\\",\\\"type\\\":\\\"context\\\",\\\"rightValueType\\\":\\\"input\\\",\\\"priority\\\":1},{\\\"property\\\":\\\"S_S_ACCTNO\\\",\\\"op\\\":\\\"==\\\",\\\"value\\\":\\\"6699660116610001965\\\",\\\"propertyDataType\\\":\\\"STRING\\\",\\\"type\\\":\\\"context\\\",\\\"rightValueType\\\":\\\"input\\\",\\\"priority\\\":2},{\\\"property\\\":\\\"S_S_MOBINO\\\",\\\"op\\\":\\\"==\\\",\\\"value\\\":\\\"18758012127\\\",\\\"propertyDataType\\\":\\\"STRING\\\",\\\"type\\\":\\\"context\\\",\\\"rightValueType\\\":\\\"input\\\",\\\"priority\\\":3},{\\\"property\\\":\\\"S_S_MOBINO\\\",\\\"op\\\":\\\"==\\\",\\\"value\\\":\\\"15987393222\\\",\\\"propertyDataType\\\":\\\"STRING\\\",\\\"type\\\":\\\"context\\\",\\\"rightValueType\\\":\\\"input\\\",\\\"priority\\\":4}]}\",\"ruleUuid\":\"ad9a74cdb7314076af1daac654d86f70\"},\"fromPoint\":\"2\",\"id\":\"51ba1450-29cc-11ed-9c7b-3b870238731b\",\"lineType\":\"ExclusiveConditionLine\",\"name\":\"黑名单手机号\",\"sourceNodeId\":\"8bc0c630281e11ed885081c62d61fab8\",\"targetNodeId\":\"502877d029cc11ed9c7b3b870238731b\",\"toPoint\":\"0\"},{\"attributes\":{},\"fromPoint\":\"2\",\"id\":\"a53dc770-29cc-11ed-9c7b-3b870238731b\",\"sourceNodeId\":\"502877d029cc11ed9c7b3b870238731b\",\"targetNodeId\":\"a3c30e5029cc11ed9c7b3b870238731b\",\"toPoint\":\"0\"},{\"attributes\":{\"conditionName\":\"18720912911\",\"priority\":1,\"condition\":\"{\\\"logicOperator\\\":\\\"||\\\",\\\"type\\\":\\\"context\\\",\\\"children\\\":[{\\\"property\\\":\\\"S_S_MOBINO\\\",\\\"op\\\":\\\"==\\\",\\\"value\\\":\\\"18720912911\\\",\\\"propertyDataType\\\":\\\"STRING\\\",\\\"type\\\":\\\"context\\\",\\\"rightValueType\\\":\\\"input\\\",\\\"priority\\\":1}]}\",\"ruleUuid\":\"063b149d30524b0f972805a2b428d6e1\"},\"fromPoint\":\"0\",\"id\":\"37d7f670-29d0-11ed-a2e1-dd0d7ed36fc8\",\"lineType\":\"ExclusiveConditionLine\",\"name\":\"18720912911\",\"sourceNodeId\":\"8bc0c630281e11ed885081c62d61fab8\",\"targetNodeId\":\"35c1e7b029d011eda2e1dd0d7ed36fc8\",\"toPoint\":\"2\"},{\"attributes\":{},\"fromPoint\":\"1\",\"id\":\"148a5bb0-301d-11ed-ad18-35c8587fc064\",\"sourceNodeId\":\"35c1e7b029d011eda2e1dd0d7ed36fc8\",\"targetNodeId\":\"4db0c44029d011eda2e1dd0d7ed36fc8\",\"toPoint\":\"3\"}],\"flowNodeDefinitions\":[{\"attributes\":{},\"id\":\"a8eedfa0185411ed9b12edb5f03c3f54\",\"incomingFields\":[],\"name\":\"开始\",\"nodeType\":\"StartFlowNode\",\"outgoingFields\":[],\"x\":\"150\",\"y\":\"223\"},{\"attributes\":{\"type\":\"start\"},\"id\":\"8bc0c630281e11ed885081c62d61fab8\",\"incomingFields\":[],\"name\":\"判断开始\",\"nodeType\":\"ExclusiveGateway\",\"outgoingFields\":[],\"x\":\"423\",\"y\":\"209\"},{\"attributes\":{\"ratingType\":2,\"nodeName\":\"保持原评级结果\"},\"id\":\"cbfd39e0293111edbf8ec53cea9dcec6\",\"incomingFields\":[],\"name\":\"保持原评级结果\",\"nodeType\":\"RateResultFlowNode\",\"outgoingFields\":[],\"x\":\"599\",\"y\":\"223\"},{\"attributes\":{},\"id\":\"cf50d1b0293111edbf8ec53cea9dcec6\",\"incomingFields\":[],\"name\":\"结束\",\"nodeType\":\"EndFlowNode\",\"outgoingFields\":[],\"x\":\"770\",\"y\":\"212\"},{\"attributes\":{\"ratingType\":3,\"nodeName\":\"加入尽职调查\"},\"id\":\"502877d029cc11ed9c7b3b870238731b\",\"incomingFields\":[],\"name\":\"加入尽职调查\",\"nodeType\":\"RateResultFlowNode\",\"outgoingFields\":[],\"x\":\"397\",\"y\":\"385\"},{\"attributes\":{},\"id\":\"a3c30e5029cc11ed9c7b3b870238731b\",\"incomingFields\":[],\"name\":\"结束\",\"nodeType\":\"EndFlowNode\",\"outgoingFields\":[],\"x\":\"428\",\"y\":\"491\"},{\"attributes\":{\"ratingType\":1,\"nodeName\":\"更新评级结果\"},\"id\":\"35c1e7b029d011eda2e1dd0d7ed36fc8\",\"incomingFields\":[],\"name\":\"更新评级结果\",\"nodeType\":\"RateResultFlowNode\",\"outgoingFields\":[],\"x\":\"397\",\"y\":\"96\"},{\"attributes\":{},\"id\":\"4db0c44029d011eda2e1dd0d7ed36fc8\",\"incomingFields\":[],\"name\":\"结束\",\"nodeType\":\"EndFlowNode\",\"outgoingFields\":[],\"x\":\"745\",\"y\":\"68\"}],\"id\":\"ef6dced894924496bd30d3c17b1abeec\",\"name\":\"qd_hb\",\"version\":1}','admin','admin','2023-04-26 11:50:18','2023-04-26 11:50:18'),('7636c5ebe3e511edb38afa6532887f00',2,'IIIOOOPP002',1,'{\"code\":\"IIIOOOPP002\",\"version\":1,\"id\":\"ef6dced894924496bd30d3c17b1abeec\",\"name\":\"IIIOOOPP002\",\"flowNodeDefinitions\":[{\"x\":206,\"y\":230,\"id\":\"db7c764033ce11edb44eb9aa8c644c47\",\"name\":\"开始\",\"nodeType\":\"StartFlowNode\",\"attributes\":{},\"incomingFields\":[],\"outgoingFields\":[]},{\"x\":334,\"y\":229,\"id\":\"dcf2747033ce11edb44eb9aa8c644c47\",\"name\":\"判断开始\",\"nodeType\":\"ExclusiveGateway\",\"attributes\":{\"type\":\"start\"},\"incomingFields\":[],\"outgoingFields\":[]},{\"x\":313,\"y\":372,\"id\":\"e246973033ce11edb44eb9aa8c644c47\",\"name\":\"加入尽职调查\",\"nodeType\":\"RateResultFlowNode\",\"attributes\":{\"ratingType\":3,\"nodeName\":\"加入尽职调查\"},\"incomingFields\":[],\"outgoingFields\":[]},{\"x\":313,\"y\":462,\"id\":\"4a17e44033cf11edb44eb9aa8c644c47\",\"name\":\"1、添加至系统名单：系统字段客户手机号码加入到黑名单； \\n\\r2、添加至系统名单：系统字段客户证件号码加入到黑灰账户名单； \\n\\r\",\"nodeType\":\"ControlsFlowNode\",\"attributes\":{\"conditions\":[{\"controlType\":1,\"field\":\"S_S_MOBINO\",\"rosterType\":1,\"rosterDefineId\":\"87bbb941d91cd324d6e5a32caf6d158f\",\"expireType\":\"byDay\",\"expireDay\":7},{\"controlType\":1,\"field\":\"S_S_CERTID\",\"rosterType\":1,\"rosterDefineId\":\"21eb818bf1dae1b3e71cb2f89df99fab\",\"expireType\":\"byDay\",\"expireDay\":7}],\"nodeName\":\"1、添加至系统名单：系统字段客户手机号码加入到黑名单； \\n\\r2、添加至系统名单：系统字段客户证件号码加入到黑灰账户名单； \\n\\r\"},\"incomingFields\":[],\"outgoingFields\":[]},{\"x\":343,\"y\":538,\"id\":\"7d45b2c033cf11edb44eb9aa8c644c47\",\"name\":\"结束\",\"nodeType\":\"EndFlowNode\",\"attributes\":{},\"incomingFields\":[],\"outgoingFields\":[]},{\"x\":582,\"y\":242,\"id\":\"87a4451033cf11edb44eb9aa8c644c47\",\"name\":\"更新评级结果\",\"nodeType\":\"RateResultFlowNode\",\"attributes\":{\"ratingType\":1,\"nodeName\":\"更新评级结果\"},\"incomingFields\":[],\"outgoingFields\":[]},{\"x\":768,\"y\":230,\"id\":\"96feef1033cf11edb44eb9aa8c644c47\",\"name\":\"结束\",\"nodeType\":\"EndFlowNode\",\"attributes\":{},\"incomingFields\":[],\"outgoingFields\":[]},{\"x\":312,\"y\":123,\"id\":\"c620122033d311ed8c55bb501f34a13e\",\"name\":\"加入尽职调查\",\"nodeType\":\"RateResultFlowNode\",\"attributes\":{\"ratingType\":3,\"nodeName\":\"加入尽职调查\"},\"incomingFields\":[],\"outgoingFields\":[]},{\"x\":510,\"y\":112,\"id\":\"e673109033d311ed8c55bb501f34a13e\",\"name\":\"结束\",\"nodeType\":\"EndFlowNode\",\"attributes\":{},\"incomingFields\":[],\"outgoingFields\":[]}],\"flowLineDefinitions\":[{\"id\":\"ecc0eee0-33ce-11ed-b44e-b9aa8c644c47\",\"fromPoint\":2,\"toPoint\":\"0\",\"attributes\":{\"conditionName\":\"账户为可疑账户或风险账户\",\"priority\":2,\"condition\":\"{\\\"logicOperator\\\":\\\"||\\\",\\\"type\\\":\\\"context\\\",\\\"children\\\":[{\\\"property\\\":\\\"C_S_CURRENTRATINGRESULT\\\",\\\"op\\\":\\\"==\\\",\\\"value\\\":\\\"可疑账户\\\",\\\"propertyDataType\\\":\\\"STRING\\\",\\\"type\\\":\\\"context\\\",\\\"rightValueType\\\":\\\"input\\\",\\\"priority\\\":1},{\\\"property\\\":\\\"C_S_CURRENTRATINGRESULT\\\",\\\"op\\\":\\\"==\\\",\\\"value\\\":\\\"风险账户\\\",\\\"propertyDataType\\\":\\\"STRING\\\",\\\"type\\\":\\\"context\\\",\\\"rightValueType\\\":\\\"input\\\",\\\"priority\\\":2}]}\"},\"sourceNodeId\":\"dcf2747033ce11edb44eb9aa8c644c47\",\"targetNodeId\":\"e246973033ce11edb44eb9aa8c644c47\",\"lineType\":\"ExclusiveConditionLine\",\"name\":\"账户为可疑账户或风险账户\"},{\"id\":\"7ae46a30-33cf-11ed-b44e-b9aa8c644c47\",\"fromPoint\":2,\"toPoint\":\"0\",\"attributes\":{},\"sourceNodeId\":\"e246973033ce11edb44eb9aa8c644c47\",\"targetNodeId\":\"4a17e44033cf11edb44eb9aa8c644c47\"},{\"id\":\"7e8b7930-33cf-11ed-b44e-b9aa8c644c47\",\"fromPoint\":2,\"toPoint\":\"0\",\"attributes\":{},\"sourceNodeId\":\"4a17e44033cf11edb44eb9aa8c644c47\",\"targetNodeId\":\"7d45b2c033cf11edb44eb9aa8c644c47\"},{\"id\":\"80497ce0-33cf-11ed-b44e-b9aa8c644c47\",\"fromPoint\":1,\"toPoint\":\"3\",\"attributes\":{},\"sourceNodeId\":\"db7c764033ce11edb44eb9aa8c644c47\",\"targetNodeId\":\"dcf2747033ce11edb44eb9aa8c644c47\"},{\"id\":\"8bbb53f0-33cf-11ed-b44e-b9aa8c644c47\",\"fromPoint\":1,\"toPoint\":\"3\",\"attributes\":{\"conditionName\":\"非风险账户或可疑账户\",\"isDefault\":true},\"sourceNodeId\":\"dcf2747033ce11edb44eb9aa8c644c47\",\"targetNodeId\":\"87a4451033cf11edb44eb9aa8c644c47\",\"lineType\":\"ExclusiveConditionLine\",\"name\":\"非风险账户或可疑账户\"},{\"id\":\"9c212c60-33cf-11ed-b44e-b9aa8c644c47\",\"fromPoint\":1,\"toPoint\":\"3\",\"attributes\":{},\"sourceNodeId\":\"87a4451033cf11edb44eb9aa8c644c47\",\"targetNodeId\":\"96feef1033cf11edb44eb9aa8c644c47\"},{\"id\":\"c7494fe0-33d3-11ed-8c55-bb501f34a13e\",\"fromPoint\":0,\"toPoint\":\"2\",\"attributes\":{\"conditionName\":\"上期命中黑名单\",\"priority\":1,\"condition\":\"{\\\"logicOperator\\\":\\\"&&\\\",\\\"type\\\":\\\"context\\\",\\\"children\\\":[{\\\"property\\\":\\\"C_B_PREISHITROSTER#87bbb941d91cd324d6e5a32caf6d158f\\\",\\\"op\\\":\\\"==\\\",\\\"value\\\":\\\"true\\\",\\\"propertyDataType\\\":\\\"BOOLEAN\\\",\\\"type\\\":\\\"context\\\",\\\"rightValueType\\\":\\\"input\\\",\\\"rosterType\\\":1,\\\"rosterDefineId\\\":\\\"87bbb941d91cd324d6e5a32caf6d158f\\\",\\\"priority\\\":1}]}\"},\"sourceNodeId\":\"dcf2747033ce11edb44eb9aa8c644c47\",\"targetNodeId\":\"c620122033d311ed8c55bb501f34a13e\",\"lineType\":\"ExclusiveConditionLine\",\"name\":\"上期命中黑名单\"},{\"id\":\"e747c5b0-33d3-11ed-8c55-bb501f34a13e\",\"fromPoint\":1,\"toPoint\":\"3\",\"attributes\":{},\"sourceNodeId\":\"c620122033d311ed8c55bb501f34a13e\",\"targetNodeId\":\"e673109033d311ed8c55bb501f34a13e\"}]}','{\"code\":\"IIIOOOPP002\",\"flowLineDefinitions\":[{\"attributes\":{\"conditionName\":\"账户为可疑账户或风险账户\",\"priority\":2,\"condition\":\"{\\\"logicOperator\\\":\\\"||\\\",\\\"type\\\":\\\"context\\\",\\\"children\\\":[{\\\"property\\\":\\\"C_S_CURRENTRATINGRESULT\\\",\\\"op\\\":\\\"==\\\",\\\"value\\\":\\\"可疑账户\\\",\\\"propertyDataType\\\":\\\"STRING\\\",\\\"type\\\":\\\"context\\\",\\\"rightValueType\\\":\\\"input\\\",\\\"priority\\\":1},{\\\"property\\\":\\\"C_S_CURRENTRATINGRESULT\\\",\\\"op\\\":\\\"==\\\",\\\"value\\\":\\\"风险账户\\\",\\\"propertyDataType\\\":\\\"STRING\\\",\\\"type\\\":\\\"context\\\",\\\"rightValueType\\\":\\\"input\\\",\\\"priority\\\":2}]}\",\"ruleUuid\":\"bf68ef223f524a0085454d68edd8d068\"},\"fromPoint\":\"2\",\"id\":\"ecc0eee0-33ce-11ed-b44e-b9aa8c644c47\",\"lineType\":\"ExclusiveConditionLine\",\"name\":\"账户为可疑账户或风险账户\",\"sourceNodeId\":\"dcf2747033ce11edb44eb9aa8c644c47\",\"targetNodeId\":\"e246973033ce11edb44eb9aa8c644c47\",\"toPoint\":\"0\"},{\"attributes\":{},\"fromPoint\":\"2\",\"id\":\"7ae46a30-33cf-11ed-b44e-b9aa8c644c47\",\"sourceNodeId\":\"e246973033ce11edb44eb9aa8c644c47\",\"targetNodeId\":\"4a17e44033cf11edb44eb9aa8c644c47\",\"toPoint\":\"0\"},{\"attributes\":{},\"fromPoint\":\"2\",\"id\":\"7e8b7930-33cf-11ed-b44e-b9aa8c644c47\",\"sourceNodeId\":\"4a17e44033cf11edb44eb9aa8c644c47\",\"targetNodeId\":\"7d45b2c033cf11edb44eb9aa8c644c47\",\"toPoint\":\"0\"},{\"attributes\":{},\"fromPoint\":\"1\",\"id\":\"80497ce0-33cf-11ed-b44e-b9aa8c644c47\",\"sourceNodeId\":\"db7c764033ce11edb44eb9aa8c644c47\",\"targetNodeId\":\"dcf2747033ce11edb44eb9aa8c644c47\",\"toPoint\":\"3\"},{\"attributes\":{\"conditionName\":\"非风险账户或可疑账户\",\"isDefault\":true},\"fromPoint\":\"1\",\"id\":\"8bbb53f0-33cf-11ed-b44e-b9aa8c644c47\",\"lineType\":\"ExclusiveConditionLine\",\"name\":\"非风险账户或可疑账户\",\"sourceNodeId\":\"dcf2747033ce11edb44eb9aa8c644c47\",\"targetNodeId\":\"87a4451033cf11edb44eb9aa8c644c47\",\"toPoint\":\"3\"},{\"attributes\":{},\"fromPoint\":\"1\",\"id\":\"9c212c60-33cf-11ed-b44e-b9aa8c644c47\",\"sourceNodeId\":\"87a4451033cf11edb44eb9aa8c644c47\",\"targetNodeId\":\"96feef1033cf11edb44eb9aa8c644c47\",\"toPoint\":\"3\"},{\"attributes\":{\"conditionName\":\"上期命中黑名单\",\"priority\":1,\"condition\":\"{\\\"logicOperator\\\":\\\"&&\\\",\\\"type\\\":\\\"context\\\",\\\"children\\\":[{\\\"property\\\":\\\"C_B_PREISHITROSTER#87bbb941d91cd324d6e5a32caf6d158f\\\",\\\"op\\\":\\\"==\\\",\\\"value\\\":\\\"true\\\",\\\"propertyDataType\\\":\\\"BOOLEAN\\\",\\\"type\\\":\\\"context\\\",\\\"rightValueType\\\":\\\"input\\\",\\\"rosterType\\\":1,\\\"rosterDefineId\\\":\\\"87bbb941d91cd324d6e5a32caf6d158f\\\",\\\"priority\\\":1}]}\",\"ruleUuid\":\"d8e3984ffd5d4ec6a5e66860481b7c0e\"},\"fromPoint\":\"0\",\"id\":\"c7494fe0-33d3-11ed-8c55-bb501f34a13e\",\"lineType\":\"ExclusiveConditionLine\",\"name\":\"上期命中黑名单\",\"sourceNodeId\":\"dcf2747033ce11edb44eb9aa8c644c47\",\"targetNodeId\":\"c620122033d311ed8c55bb501f34a13e\",\"toPoint\":\"2\"},{\"attributes\":{},\"fromPoint\":\"1\",\"id\":\"e747c5b0-33d3-11ed-8c55-bb501f34a13e\",\"sourceNodeId\":\"c620122033d311ed8c55bb501f34a13e\",\"targetNodeId\":\"e673109033d311ed8c55bb501f34a13e\",\"toPoint\":\"3\"}],\"flowNodeDefinitions\":[{\"attributes\":{},\"id\":\"db7c764033ce11edb44eb9aa8c644c47\",\"incomingFields\":[],\"name\":\"开始\",\"nodeType\":\"StartFlowNode\",\"outgoingFields\":[],\"x\":\"206\",\"y\":\"230\"},{\"attributes\":{\"type\":\"start\"},\"id\":\"dcf2747033ce11edb44eb9aa8c644c47\",\"incomingFields\":[],\"name\":\"判断开始\",\"nodeType\":\"ExclusiveGateway\",\"outgoingFields\":[],\"x\":\"334\",\"y\":\"229\"},{\"attributes\":{\"ratingType\":3,\"nodeName\":\"加入尽职调查\"},\"id\":\"e246973033ce11edb44eb9aa8c644c47\",\"incomingFields\":[],\"name\":\"加入尽职调查\",\"nodeType\":\"RateResultFlowNode\",\"outgoingFields\":[],\"x\":\"313\",\"y\":\"372\"},{\"attributes\":{\"conditions\":[{\"controlType\":1,\"field\":\"S_S_MOBINO\",\"rosterType\":1,\"rosterDefineId\":\"87bbb941d91cd324d6e5a32caf6d158f\",\"expireType\":\"byDay\",\"expireDay\":7},{\"controlType\":1,\"field\":\"S_S_CERTID\",\"rosterType\":1,\"rosterDefineId\":\"21eb818bf1dae1b3e71cb2f89df99fab\",\"expireType\":\"byDay\",\"expireDay\":7}],\"nodeName\":\"1、添加至系统名单：系统字段客户手机号码加入到黑名单； \\n\\r2、添加至系统名单：系统字段客户证件号码加入到黑灰账户名单； \\n\\r\"},\"id\":\"4a17e44033cf11edb44eb9aa8c644c47\",\"incomingFields\":[],\"name\":\"1、添加至系统名单：系统字段客户手机号码加入到黑名单； \\n\\r2、添加至系统名单：系统字段客户证件号码加入到黑灰账户名单； \\n\\r\",\"nodeType\":\"ControlsFlowNode\",\"outgoingFields\":[],\"x\":\"313\",\"y\":\"462\"},{\"attributes\":{},\"id\":\"7d45b2c033cf11edb44eb9aa8c644c47\",\"incomingFields\":[],\"name\":\"结束\",\"nodeType\":\"EndFlowNode\",\"outgoingFields\":[],\"x\":\"343\",\"y\":\"538\"},{\"attributes\":{\"ratingType\":1,\"nodeName\":\"更新评级结果\"},\"id\":\"87a4451033cf11edb44eb9aa8c644c47\",\"incomingFields\":[],\"name\":\"更新评级结果\",\"nodeType\":\"RateResultFlowNode\",\"outgoingFields\":[],\"x\":\"582\",\"y\":\"242\"},{\"attributes\":{},\"id\":\"96feef1033cf11edb44eb9aa8c644c47\",\"incomingFields\":[],\"name\":\"结束\",\"nodeType\":\"EndFlowNode\",\"outgoingFields\":[],\"x\":\"768\",\"y\":\"230\"},{\"attributes\":{\"ratingType\":3,\"nodeName\":\"加入尽职调查\"},\"id\":\"c620122033d311ed8c55bb501f34a13e\",\"incomingFields\":[],\"name\":\"加入尽职调查\",\"nodeType\":\"RateResultFlowNode\",\"outgoingFields\":[],\"x\":\"312\",\"y\":\"123\"},{\"attributes\":{},\"id\":\"e673109033d311ed8c55bb501f34a13e\",\"incomingFields\":[],\"name\":\"结束\",\"nodeType\":\"EndFlowNode\",\"outgoingFields\":[],\"x\":\"510\",\"y\":\"112\"}],\"id\":\"ef6dced894924496bd30d3c17b1abeec\",\"name\":\"IIIOOOPP002\",\"version\":1}','admin','admin','2023-04-26 11:50:18','2023-04-26 11:50:18');

--
-- Table structure for table `account_follow_roster`
--

DROP TABLE IF EXISTS `account_follow_roster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_follow_roster` (
                                         `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
                                         `account_id` varchar(64) NOT NULL COMMENT '账户id',
                                         `cust_type` tinyint(4) DEFAULT NULL COMMENT '客户类型 1-对私 2-对公',
                                         `cust_no` varchar(64) DEFAULT NULL COMMENT '客户编号',
                                         `cust_name` varchar(64) DEFAULT NULL COMMENT '客户名称',
                                         `account_no` varchar(64) DEFAULT NULL COMMENT '交易账号',
                                         `open_branch` varchar(64) DEFAULT NULL COMMENT '开户网点',
                                         `data_status` tinyint(4) DEFAULT '0' COMMENT '数据状态 0-禁用 1-启用',
                                         `outoftune_task_id` varchar(64) DEFAULT NULL COMMENT '关联尽职调查任务id',
                                         `effective_time` datetime NOT NULL COMMENT '生效时间',
                                         `invalid_time` datetime NOT NULL COMMENT '失效时间',
                                         `create_by` varchar(36) NOT NULL COMMENT '创建人',
                                         `modify_by` varchar(36) NOT NULL COMMENT '修改人',
                                         `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                         `gmt_modify` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                                         `version` int(11) DEFAULT '0' COMMENT '乐观锁 版本号',
                                         PRIMARY KEY (`id`),
                                         KEY `IDX_FOLROSTER_ACCTID` (`account_id`) USING BTREE,
                                         KEY `IDX_FOLROSTER_ACCTNO` (`account_no`) USING BTREE,
                                         KEY `IDX_FOLROSTER_CUST_INFO` (`cust_type`,`cust_no`,`cust_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='账户评级持续关注名单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_follow_roster`
--


--
-- Table structure for table `account_immune_roster`
--

DROP TABLE IF EXISTS `account_immune_roster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_immune_roster` (
                                         `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
                                         `account_id` varchar(64) NOT NULL COMMENT '账户id',
                                         `cust_type` tinyint(4) DEFAULT NULL COMMENT '客户类型 1-对私 2-对公',
                                         `cust_no` varchar(64) DEFAULT NULL COMMENT '客户编号',
                                         `cust_name` varchar(64) DEFAULT NULL COMMENT '客户名称',
                                         `account_no` varchar(64) DEFAULT NULL COMMENT '交易账号',
                                         `open_branch` varchar(64) DEFAULT NULL COMMENT '开户网点',
                                         `data_status` tinyint(4) DEFAULT '0' COMMENT '数据状态 0-禁用 1-启用',
                                         `policy_uuid` varchar(64) DEFAULT NULL COMMENT '白名单策略uuid',
                                         `add_way` tinyint(1) DEFAULT NULL COMMENT '添加方式 1-手动 2-尽职调查',
                                         `channel_name` varchar(255) DEFAULT NULL COMMENT '渠道名称',
                                         `invalid_day` int(11) NOT NULL COMMENT '有效期（天）',
                                         `effective_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '生效时间',
                                         `invalid_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '失效时间',
                                         `expire_type` tinyint(1) DEFAULT NULL COMMENT '过期类型 1-指定天数 2-指定日期',
                                         `remark` varchar(256) DEFAULT NULL COMMENT '备注',
                                         `create_by` varchar(36) NOT NULL COMMENT '创建人',
                                         `modify_by` varchar(36) NOT NULL COMMENT '修改人',
                                         `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                         `gmt_modify` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                                         `version` int(11) DEFAULT '0' COMMENT '乐观锁 版本号',
                                         PRIMARY KEY (`id`) USING BTREE,
                                         UNIQUE KEY `uk_policy_number_trading` (`policy_uuid`,`account_id`) USING BTREE,
                                         KEY `IDX_IMMROSTER_ACCTID` (`account_id`) USING BTREE,
                                         KEY `IDX_IMMROSTER_ACCTNO` (`account_no`) USING BTREE,
                                         KEY `IDX_IMMROSTER_CUST_INFO` (`cust_type`,`cust_no`,`cust_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='账户策略免疫名单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_immune_roster`
--


--
-- Table structure for table `account_info`
--

DROP TABLE IF EXISTS `account_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_info` (
                                `id` varchar(64) NOT NULL COMMENT 'id',
                                `cust_type` tinyint(4) NOT NULL COMMENT '账户类型 1-对私 2-对公',
                                `account_no` varchar(64) DEFAULT NULL COMMENT '交易账号',
                                `cust_name` varchar(64) DEFAULT NULL COMMENT '客户名称',
                                `cust_no` varchar(64) NOT NULL COMMENT '客户编号',
                                `cert_id` varchar(64) DEFAULT NULL COMMENT '客户证件号',
                                `open_branch` varchar(64) DEFAULT NULL COMMENT '开户网点',
                                `ext_info` text COMMENT '扩展额外属性',
                                `create_by` varchar(36) NOT NULL COMMENT '创建人',
                                `modify_by` varchar(36) NOT NULL COMMENT '修改人',
                                `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                `gmt_modify` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                                PRIMARY KEY (`id`) USING BTREE,
                                UNIQUE KEY `uk_no_type` (`account_no`,`cust_type`) USING BTREE,
                                KEY `uk_id_type` (`cert_id`,`cust_type`) USING BTREE,
                                KEY `IDX_ACCTINFO_CUST_INFO` (`cust_no`,`cust_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='账户信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_info`
--


--
-- Table structure for table `account_outoftune_form`
--

DROP TABLE IF EXISTS `account_outoftune_form`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_outoftune_form` (
                                          `uuid` varchar(64) NOT NULL COMMENT 'uuid 表单编号',
                                          `name` varchar(64) DEFAULT NULL COMMENT '表单名称',
                                          `type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '表单类型 1-对私开户尽调调查表 2-对公开户尽调调查表 3-对私持续尽调调查表 4-对公持续尽调调查表',
                                          `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '使用状态 1-启用 0-禁用 默认禁用',
                                          `create_by` varchar(36) NOT NULL COMMENT '创建人',
                                          `modify_by` varchar(36) NOT NULL COMMENT '修改人',
                                          `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                          `gmt_modify` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                                          PRIMARY KEY (`uuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='尽职调查表单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_outoftune_form`
--

INSERT INTO `account_outoftune_form` (`uuid`, `name`, `type`, `status`, `create_by`, `modify_by`, `gmt_create`, `gmt_modify`) VALUES ('DG0001','对公开户尽调表单-勿动',2,1,'admin','admin','2022-11-22 18:29:54','2022-11-22 18:30:14'),('DG0002','对公评级尽调表单-勿动',4,1,'admin','admin','2022-11-22 18:30:32','2022-11-22 18:30:48'),('DS0001','对私开户尽调表单-勿动',1,1,'admin','admin','2022-11-22 13:54:01','2022-11-22 13:56:48'),('DS0002','对私评级尽调表单-勿动',3,1,'admin','admin','2022-11-22 15:16:09','2022-11-22 18:29:37');

--
-- Table structure for table `account_outoftune_form_group`
--

DROP TABLE IF EXISTS `account_outoftune_form_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_outoftune_form_group` (
                                                `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
                                                `form_uuid` varchar(64) NOT NULL COMMENT '表单编号',
                                                `form_group` varchar(64) NOT NULL COMMENT '表单分组',
                                                `form_group_name` varchar(64) NOT NULL COMMENT '表单分组名称',
                                                `field_name` varchar(64) DEFAULT NULL COMMENT '字段标识',
                                                `field_display_name` varchar(128) DEFAULT NULL COMMENT '字段名称',
                                                `check_type` varchar(8) DEFAULT NULL COMMENT '排查类型 E-单选 M-多选 S-输入框',
                                                `check_options` varchar(255) DEFAULT NULL COMMENT '排查选项 枚举值JSON或"手工录入"',
                                                `if_required` tinyint(4) DEFAULT NULL COMMENT '是否必填 1-是 0-否',
                                                `create_by` varchar(36) NOT NULL COMMENT '创建人',
                                                `modify_by` varchar(36) NOT NULL COMMENT '修改人',
                                                `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                                `gmt_modify` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                                                PRIMARY KEY (`id`) USING BTREE,
                                                UNIQUE KEY `uk_form_name` (`form_uuid`,`field_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='尽职调查表单-分组内容';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_outoftune_form_group`
--


--
-- Table structure for table `account_outoftune_task`
--

DROP TABLE IF EXISTS `account_outoftune_task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_outoftune_task` (
                                          `uuid` varchar(64) NOT NULL COMMENT '尽职调查任务编号',
                                          `account_id` varchar(64) DEFAULT NULL COMMENT '账户id',
                                          `cust_type` tinyint(4) DEFAULT NULL COMMENT '客户类型 1-对私 2-对公',
                                          `cust_no` varchar(64) DEFAULT NULL COMMENT '客户编号 对公-统一社会信用代码 对私-证件号码',
                                          `cust_name` varchar(64) DEFAULT NULL COMMENT '客户名称',
                                          `account_no` varchar(64) DEFAULT NULL COMMENT '交易账号',
                                          `open_branch` varchar(64) DEFAULT NULL COMMENT '开户网点',
                                          `type` tinyint(4) DEFAULT NULL COMMENT '尽职调查任务类型 1-对私开户尽职调查 2-对公开户尽职调查 3-持续尽职调查 4-强化尽职调查',
                                          `associated_no` varchar(64) DEFAULT NULL COMMENT '关联任务单编号-客户业务系统回传',
                                          `token_id` varchar(64) DEFAULT NULL COMMENT 'tokenId 开户及持续尽调非空',
                                          `status` tinyint(4) DEFAULT '1' COMMENT '尽职调查任务状态 1-进行中 2-待认定 3-已完成 4-待审核 5-已结束',
                                          `current_rating` varchar(64) DEFAULT NULL COMMENT '账户当前风险评级',
                                          `current_rating_time` datetime DEFAULT NULL COMMENT '评级更新时间',
                                          `current_period_rating` varchar(64) DEFAULT NULL COMMENT '账户本期风险评级',
                                          `current_period_rating_time` datetime DEFAULT NULL COMMENT '本期评级时间',
                                          `final_rating` varchar(64) DEFAULT NULL COMMENT '账户最终风险评级',
                                          `check_items` text COMMENT '排查项目，尽调时保存尽调模版内容',
                                          `expect_complete_time` datetime DEFAULT NULL COMMENT '预期完成时间',
                                          `end_time` datetime DEFAULT NULL COMMENT '尽职调查完成时间',
                                          `template_no` varchar(64) DEFAULT NULL COMMENT '模板编号',
                                          `if_confirm` tinyint(1) DEFAULT NULL COMMENT '是否待认定 1-是 0-否',
                                          `resume` varchar(2048) DEFAULT NULL COMMENT '简述',
                                          `check_person` varchar(64) DEFAULT NULL COMMENT '排查人',
                                          `create_by` varchar(36) NOT NULL COMMENT '创建人',
                                          `modify_by` varchar(36) NOT NULL COMMENT '修改人',
                                          `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间 尽职调查发起时间',
                                          `gmt_modify` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                                          PRIMARY KEY (`uuid`),
                                          KEY `IDX_OUTTASK_ACCTID` (`account_id`) USING BTREE,
                                          KEY `IDX_OUTTASK_ACCTNO` (`account_no`) USING BTREE,
                                          KEY `IDX_OUTTASK_TYPE` (`type`) USING BTREE,
                                          KEY `IDX_OUTTASK_CUST_INFO` (`cust_type`,`cust_no`,`cust_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='账户尽职调查历史表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_outoftune_task`
--


--
-- Table structure for table `account_rating_detail_config`
--

DROP TABLE IF EXISTS `account_rating_detail_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_rating_detail_config` (
                                                `uuid` varchar(32) NOT NULL COMMENT '主键',
                                                `cust_type` tinyint(4) NOT NULL COMMENT '客户类型，1-对私，2-对公',
                                                `group_info` text NOT NULL COMMENT '配置信息',
                                                `note` varchar(128) DEFAULT NULL COMMENT '备注',
                                                `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '当前时间',
                                                `gmt_modify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
                                                `create_by` varchar(128) NOT NULL COMMENT '创建人',
                                                `modify_by` varchar(128) NOT NULL COMMENT '更新人',
                                                PRIMARY KEY (`uuid`),
                                                KEY `ACCT_RATING_DETAIL_CONFIG_INDEX` (`cust_type`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_rating_detail_config`
--

INSERT INTO `account_rating_detail_config` (`uuid`, `cust_type`, `group_info`, `note`, `gmt_create`, `gmt_modify`, `create_by`, `modify_by`) VALUES ('764032afe3e511edb38afa6532887f00',2,'[{\"groupName\":\"基本信息\",\"systemFields\":[{\"field\":\"S_S_MOBINO\",\"highLight\":false},{\"field\":\"S_S_CERTID\",\"highLight\":false},{\"field\":\"S_S_ACCTNO\",\"highLight\":false},{\"field\":\"S_S_CUSTNO\",\"highLight\":false},{\"field\":\"S_E_CUSTTYPE\",\"highLight\":true},{\"field\":\"S_S_CUSTNAME\",\"highLight\":false},{\"field\":\"S_S_IDNO\",\"highLight\":false}]},{\"groupName\":\"评级信息\",\"systemFields\":[{\"field\":\"C_S_ACCTCURRRATING\",\"highLight\":true},{\"field\":\"C_S_CURRPERIODRATING\",\"highLight\":false},{\"field\":\"C_S_CONTROLMEASURE\",\"highLight\":false}]},{\"groupName\":\"TEST1\",\"systemFields\":[{\"field\":\"S_E_CREDITRESULT\",\"highLight\":false},{\"field\":\"S_E_SHRHLDERIND\",\"highLight\":false},{\"field\":\"S_S_MPSUBID\",\"highLight\":false}]},{\"groupName\":\"TEST2\",\"systemFields\":[{\"field\":\"S_S_MERMANUALACCESSLEVEL\",\"highLight\":false},{\"field\":\"S_S_COMPANY\",\"highLight\":false},{\"field\":\"S_S_RISKLABEL\",\"highLight\":false},{\"field\":\"C_F_ACCTRSTDLMT\",\"highLight\":false},{\"field\":\"S_S_APPCODE\",\"highLight\":false},{\"field\":\"S_S_ORGCODE\",\"highLight\":false}]}]',NULL,'2023-04-26 03:50:18','2023-04-26 03:50:18','admin','admin'),('76468b54e3e511edb38afa6532887f00',1,'[{\"groupName\":\"基本信息\",\"systemFields\":[{\"field\":\"S_S_CUSTNO\",\"highLight\":true},{\"field\":\"S_S_CUSTNAME\",\"highLight\":true},{\"field\":\"S_E_CUSTTYPE\",\"highLight\":false},{\"field\":\"S_S_MOBINO\",\"highLight\":false},{\"field\":\"S_S_IDNO\",\"highLight\":false}]},{\"groupName\":\"评级信息\",\"systemFields\":[{\"field\":\"C_S_ACCTCURRRATING\",\"highLight\":true},{\"field\":\"C_S_ACCTCURRTIME\",\"highLight\":false}]},{\"groupName\":\"其他信息\",\"systemFields\":[{\"field\":\"S_S_COMPANY\",\"highLight\":false},{\"field\":\"S_S_CERTID\",\"highLight\":true}]},{\"groupName\":\"测试信息\",\"systemFields\":[{\"field\":\"C_S_CONTROLMEASURE\",\"highLight\":false},{\"field\":\"S_S_RISKLABEL\",\"highLight\":false},{\"field\":\"S_S_ACCTNO\",\"highLight\":false},{\"field\":\"S_S_ORGCODE\",\"highLight\":false},{\"field\":\"S_S_APPCODE\",\"highLight\":false}]}]',NULL,'2023-04-26 03:50:18','2023-04-26 03:50:18','admin','admin');

--
-- Table structure for table `account_risk_rating`
--

DROP TABLE IF EXISTS `account_risk_rating`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_risk_rating` (
                                       `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
                                       `account_id` varchar(64) DEFAULT NULL COMMENT '账号id',
                                       `cust_type` tinyint(4) DEFAULT NULL COMMENT '客户类型 1-对私 2-对公',
                                       `cust_no` varchar(64) DEFAULT NULL COMMENT '客户编号',
                                       `cust_name` varchar(64) DEFAULT NULL COMMENT '客户名称',
                                       `account_no` varchar(64) DEFAULT NULL COMMENT '交易账号',
                                       `open_branch` varchar(64) DEFAULT NULL COMMENT '开户网点',
                                       `current_rating` varchar(64) DEFAULT NULL COMMENT '账户风险评级',
                                       `rating_last_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次评级时间',
                                       `control_measures` varchar(255) DEFAULT NULL COMMENT '管控措施 多个以,号分割',
                                       `create_by` varchar(36) NOT NULL COMMENT '创建人',
                                       `modify_by` varchar(36) NOT NULL COMMENT '修改人',
                                       `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                       `gmt_modify` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                                       PRIMARY KEY (`id`) USING BTREE,
                                       UNIQUE KEY `uk_account` (`account_id`) USING BTREE,
                                       KEY `IDX_GMT_MODIFY` (`gmt_modify`) USING BTREE,
                                       KEY `IDX_RISKRATING_ACCTNO` (`account_no`) USING BTREE,
                                       KEY `IDX_RISKRATING_CUST_INFO` (`cust_type`,`cust_no`,`cust_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='账户风险评级表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_risk_rating`
--


--
-- Table structure for table `account_suspicious`
--

DROP TABLE IF EXISTS `account_suspicious`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_suspicious` (
                                      `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
                                      `account_id` varchar(64) NOT NULL COMMENT '账号id',
                                      `cust_type` tinyint(4) DEFAULT NULL COMMENT '客户类型 1-对私 2-对公',
                                      `cust_no` varchar(64) DEFAULT NULL COMMENT '客户编号',
                                      `cust_name` varchar(64) DEFAULT NULL COMMENT '客户名称',
                                      `account_no` varchar(64) DEFAULT NULL COMMENT '交易账号',
                                      `open_branch` varchar(64) DEFAULT NULL COMMENT '开户网点',
                                      `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '尽调状态 1-待尽调 2-尽调中 3-已完成',
                                      `add_mode` tinyint(4) NOT NULL COMMENT '添加方式，1-人工添加；2-导入名单添加；3-系统自动添加',
                                      `create_by` varchar(36) NOT NULL COMMENT '创建人',
                                      `modify_by` varchar(36) NOT NULL COMMENT '修改人',
                                      `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                      `gmt_modify` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                                      `current_period_rating` varchar(32) DEFAULT NULL COMMENT '本期风险评级',
                                      `current_period_time` datetime DEFAULT NULL COMMENT '本期评级更新时间',
                                      PRIMARY KEY (`id`) USING BTREE,
                                      UNIQUE KEY `uk_code_trading` (`account_id`) USING BTREE,
                                      KEY `IDX_SUSPICIOUS_ACCTNO` (`account_no`) USING BTREE,
                                      KEY `IDX_SUSPICIOUS_CUST_INFO` (`cust_type`,`cust_no`,`cust_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='可疑账户名单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_suspicious`
--


--
-- Table structure for table `account_suspicious_temp`
--

DROP TABLE IF EXISTS `account_suspicious_temp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_suspicious_temp` (
                                           `batch_id` varchar(64) NOT NULL COMMENT '批次号',
                                           `cust_type` tinyint(4) DEFAULT NULL COMMENT '客户类型，1-对私，2-对公',
                                           `roster_type` tinyint(4) NOT NULL COMMENT '名单，1-问题账户，2-问题客户',
                                           `data` varchar(64) NOT NULL COMMENT '数据值',
                                           KEY `INDEX_SUSPICIOUS_BATCH_ID` (`batch_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_suspicious_temp`
--

/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-14 16:36:31



--
-- 初始化数据
--


DELETE FROM tiangong_rule_dealtype WHERE deal_type IN ('credible','ordinary','concerned','suspicious','risk');

INSERT INTO `tiangong_rule_dealtype` (`uuid`, `deal_type`, `deal_name`, `grade`, `gmt_create`, `gmt_modify`, `create_by`, `update_by`, `is_default`, `color`)
VALUES
    ('credible', 'credible', '可信账户', 20, '2021-08-31 11:25:41', '2021-11-26 17:11:41', 'xyz', 'admin', 1, '#5AD8A6'),
    ('ordinary', 'ordinary', '普通账户', 10, '2021-08-31 11:33:05', '2021-09-06 19:37:04', 'xyz', 'xyz', 1, '#6DC8EC'),
    ('concerned', 'concerned', '关注账户', 30, '2021-09-06 19:43:24', '2021-09-07 09:31:12', 'xyz', 'xyz', 1, '#F6BD16'),
    ('suspicious', 'suspicious', '可疑账户', 40, '2021-08-31 11:25:41', '2021-11-26 17:11:41', 'xyz', 'admin', 1, '#FF9845'),
    ('risk', 'risk', '风险账户', 50, '2021-08-31 11:33:05', '2021-09-06 19:37:04', 'xyz', 'xyz', 1, '#E86452');

DELETE FROM bifrost_dictionary WHERE mykey='Account';
DELETE FROM bifrost_dictionary WHERE mykey='customerType';
DELETE FROM bifrost_dictionary WHERE mykey='ifConfirm';
DELETE FROM bifrost_dictionary WHERE mykey='templateFunctionType';
INSERT INTO `bifrost_dictionary` (`uuid`, `mykey`, `myvalue`, `groups`, `created_by`, `updated_by`, `gmt_create`, `gmt_modified`, `gmt_modify`, `description`, `default_flag`)
VALUES
    ('06404fba82c411eebd86fa6532887f00', 'ifConfirm', '[{\"name\":\"0\",\"dName\":\"否\",\"enDName\":\"No\"},{\"name\":\"1\",\"dName\":\"是\",\"enDName\":\"Yes\"}]', '[\"auditForm\"]', 'admin', 'admin', '2023-11-14 16:01:32', '2023-11-14 16:01:32', '2023-11-14 16:01:32', '是否需要尽调结果认定', 1),
    ('0655c63682c411eebd86fa6532887f00', 'templateFunctionType', '[{\"name\":\"outoftunetask\",\"dName\":\"尽职调查任务单审批\"},{\"name\":\"outoftuneresult\",\"dName\":\"尽职调查结果认定\"},{\"name\":\"basic\",\"dName\":\"初级\"},{\"name\":\"intermediate\",\"dName\":\"中级\"},{\"name\":\"advanced\",\"dName\":\"高级\"}]', '[\"system\"]', 'admin', 'admin', '2023-11-14 16:01:32', '2023-11-14 16:01:33', '2023-11-14 16:01:33', '', 1),
    ('06720ed582c411eebd86fa6532887f00', 'customerType', '[{\"name\":\"1\",\"dName\":\"对私\",\"enDName\":\"forPrivate\"},{\"name\":\"2\",\"dName\":\"对公\",\"enDName\":\"forPublic\"},{\"name\":\"3\",\"dName\":\"同业\",\"enDName\":\"forBusiness\"}]', '[\"system\"]', 'admin', 'admin', '2023-11-14 16:01:32', '2023-11-14 16:01:32', '2023-11-14 16:01:32', '供前端列表展示使用', 1),
    ('06b7efa882c411eebd86fa6532887f00', 'Account', '[{\"name\":\"S_E_CUSTTYPE\",\"dName\":\"客户类型\"},{\"name\":\"S_S_CUSTNAME\",\"dName\":\"客户名称\"},{\"name\":\"S_S_CUSTNO\",\"dName\":\"客户号\"},{\"name\":\"S_S_ACCTNO\",\"dName\":\"交易账号\"}]', '[\"system\"]', 'admin', 'admin', '2023-11-14 16:01:33', '2023-11-14 16:01:33', '2023-11-14 16:01:33', '账户四要素', 1);


DELETE FROM bifrost_field_group WHERE `name`='ACCTRATING';
INSERT INTO `bifrost_field_group` (`uuid`, `display_name`, `name`, `description`, `gmt_create`, `gmt_modified`)
VALUES
    ('83ffbf89-75c4-410d-adec-b9e701251022', '账户风险评级', 'ACCTRATING', '账户风险评级内置字段', '2022-08-18 17:04:09', '2022-08-18 17:04:09');


DELETE FROM bifrost_system_config WHERE config_key='accountControlMeasures';
DELETE FROM bifrost_system_config WHERE config_key='accountRiskCodes';
DELETE FROM bifrost_system_config WHERE config_key='outOfTuneDataField';
DELETE FROM bifrost_system_config WHERE config_key='outOfTuneTaskDefaultTime';
DELETE FROM bifrost_system_config WHERE config_key='policyTestTableConfig';
DELETE FROM bifrost_system_config WHERE config_key='taskFlowNodeConfig';
DELETE FROM bifrost_system_config WHERE config_key='useOutOfTuneSync';
DELETE FROM bifrost_system_config WHERE config_key='useSystemTaskProcess';
DELETE FROM bifrost_system_config WHERE config_key='whiteListFocusTimeOut';
INSERT INTO `bifrost_system_config` (`uuid`, `gmt_create`, `gmt_modify`, `config_key`, `config_value`, `created_by`, `updated_by`, `description`, `status`, `type`)
VALUES
    ('6d00ec43e3ef11edb38afa6532887f00', '2023-04-26 13:01:38', '2023-04-26 13:01:38', 'outOfTuneTaskDefaultTime', '1', 'admin', 'admin', '尽职调查任务默认开展时间（单位：天）超过预期时间的尽职调查任务会自动生成预警记录', 1, 'String'),
    ('6d0c32f1e3ef11edb38afa6532887f00', '2023-04-26 13:01:38', '2023-04-26 13:01:38', 'useSystemTaskProcess', 'true', 'admin', 'admin', '是否使用系统自带任务流程系统', 1, 'Boolean'),
    ('6d1e7cd7e3ef11edb38afa6532887f00', '2023-04-26 13:01:38', '2023-04-26 13:01:38', 'accountRiskCodes', '{\"riskCodes\":[{\"name\":\"credible\",\"dName\":\"可信账户\",\"color\":\"#00C890\"},{\"name\":\"ordinary\",\"dName\":\"普通账户\",\"color\":\"#5B8FF9\"},{\"name\":\"concerned\",\"dName\":\"关注账户\",\"color\":\"#FF9845\"},{\"name\":\"suspicious\",\"dName\":\"可疑账户\",\"color\":\"#945FB9\"},{\"name\":\"risk\",\"dName\":\"风险账户\",\"color\":\"#D96156\"}]}', 'admin', 'admin', '账户风险评级结果', 1, 'Json'),
    ('6d38032fe3ef11edb38afa6532887f00', '2023-04-26 13:01:38', '2023-04-26 13:01:38', 'whiteListFocusTimeOut', '10', 'admin', 'admin', '评级白名单默认关注时间（单位：天）', 1, 'String'),
    ('6d496cb5e3ef11edb38afa6532887f00', '2023-04-26 13:01:38', '2023-04-26 13:01:38', 'accountControlMeasures', '{\"controlMeasures\":[{\"name\":\"1\",\"displayName\":\"限制账户非柜面交易\"},{\"name\":\"2\",\"displayName\":\"暂停新开户\"},{\"name\":\"3\",\"displayName\":\"暂停柜面业务\"},{\"name\":\"4\",\"displayName\":\"上报反洗钱案例\"}]}', 'admin', 'admin', '账户管控措施', 1, 'Json'),
    ('6eb6df6de3ef11edb38afa6532887f00', '2023-04-26 13:01:41', '2023-04-26 13:01:41', 'policyTestTableConfig', '{\"CreditScene\":[{\"columnIndex\":\"uuid\",\"columnName\":\"测试流水号\"},{\"columnIndex\":\"endTime\",\"columnName\":\"测试时间\"},{\"columnIndex\":\"policyName\",\"columnName\":\"策略名称\"},{\"columnIndex\":\"S_S_CUSTNAME\",\"columnName\":\"客户名称\",\"columnPrefix\":\"params\"},{\"columnIndex\":\"S_S_CERTID\",\"columnName\":\"客户证件号码\",\"columnPrefix\":\"params\"},{\"columnIndex\":\"S_S_PHONENO\",\"columnName\":\"电话号码\",\"columnPrefix\":\"params\"},{\"columnIndex\":\"runStatus\",\"columnName\":\"运行状态\"},{\"columnIndex\":\"policyDealTypeName\",\"columnName\":\"测试结果\"},{\"columnIndex\":\"operator\",\"columnName\":\"测试人\"}],\"AtreusLoan\":[{\"columnIndex\":\"uuid\",\"columnName\":\"测试流水号\"},{\"columnIndex\":\"endTime\",\"columnName\":\"测试时间\"},{\"columnIndex\":\"policyName\",\"columnName\":\"策略名称\"},{\"columnIndex\":\"policyVersionStatus\",\"columnName\":\"策略状态\"},{\"columnIndex\":\"runStatus\",\"columnName\":\"运行状态\"},{\"columnIndex\":\"policyDealTypeName\",\"columnName\":\"测试结果\"},{\"columnIndex\":\"bizType\",\"columnName\":\"业务类型\"},{\"columnIndex\":\"S_S_CUSTNAME\",\"columnName\":\"客户名称\",\"columnPrefix\":\"params\"},{\"columnIndex\":\"S_S_CERTID\",\"columnName\":\"证件号码\",\"columnPrefix\":\"params\"},{\"columnIndex\":\"S_S_PHONENO\",\"columnName\":\"联系方式\",\"columnPrefix\":\"params\"},{\"columnIndex\":\"operator\",\"columnName\":\"测试人\"}],\"PostloanScene\":[{\"columnIndex\":\"uuid\",\"columnName\":\"测试流水号\"},{\"columnIndex\":\"endTime\",\"columnName\":\"测试时间\"},{\"columnIndex\":\"policyName\",\"columnName\":\"策略名称\"},{\"columnIndex\":\"S_S_CUSTNAME\",\"columnName\":\"客户名称\",\"columnPrefix\":\"params\"},{\"columnIndex\":\"S_S_CERTID\",\"columnName\":\"客户证件号码\",\"columnPrefix\":\"params\"},{\"columnIndex\":\"S_S_CONTPHONE\",\"columnName\":\"电话号码\",\"columnPrefix\":\"params\"},{\"columnIndex\":\"runStatus\",\"columnName\":\"运行状态\"},{\"columnIndex\":\"policyDealTypeName\",\"columnName\":\"测试结果\"},{\"columnIndex\":\"operator\",\"columnName\":\"测试人\"}],\"TradeScene\":[{\"columnIndex\":\"uuid\",\"columnName\":\"测试流水号\"},{\"columnIndex\":\"endTime\",\"columnName\":\"测试时间\"},{\"columnIndex\":\"policyName\",\"columnName\":\"策略名称\"},{\"columnIndex\":\"S_S_CUSTNO\",\"columnName\":\"客户编号\",\"columnPrefix\":\"params\"},{\"columnIndex\":\"runStatus\",\"columnName\":\"运行状态\"},{\"columnIndex\":\"policyDealTypeName\",\"columnName\":\"测试结果\"},{\"columnIndex\":\"S_F_AMOUNT\",\"columnName\":\"交易金额\",\"columnPrefix\":\"params\"},{\"columnIndex\":\"S_S_IPADDR\",\"columnName\":\"IP地址\",\"columnPrefix\":\"params\"},{\"columnIndex\":\"operator\",\"columnName\":\"测试人\"}],\"MerchantScene\":[{\"columnIndex\":\"uuid\",\"columnName\":\"测试流水号\"},{\"columnIndex\":\"endTime\",\"columnName\":\"测试时间\"},{\"columnIndex\":\"policyName\",\"columnName\":\"策略名称\"},{\"columnIndex\":\"S_S_MERNAME\",\"columnName\":\"商户名称\",\"columnPrefix\":\"params\"},{\"columnIndex\":\"S_S_MERNO\",\"columnName\":\"商户编号\",\"columnPrefix\":\"params\"},{\"columnIndex\":\"S_S_CORPPHONE\",\"columnName\":\"法人联系电话\",\"columnPrefix\":\"params\"},{\"columnIndex\":\"S_S_LEGALPERSONNAME\",\"columnName\":\"法人姓名\",\"columnPrefix\":\"params\"},{\"columnIndex\":\"runStatus\",\"columnName\":\"运行状态\"},{\"columnIndex\":\"policyDealTypeName\",\"columnName\":\"测试结果\"},{\"columnIndex\":\"operator\",\"columnName\":\"测试人\"}],\"Account\":[{\"columnIndex\":\"uuid\",\"columnName\":\"测试流水号\"},{\"columnIndex\":\"endTime\",\"columnName\":\"测试时间\"},{\"columnIndex\":\"policyName\",\"columnName\":\"策略名称\"},{\"columnIndex\":\"S_S_ACCTNO\",\"columnName\":\"交易账号\",\"columnPrefix\":\"params\"},{\"columnIndex\":\"S_S_CUSTNAME\",\"columnName\":\"客户名称\",\"columnPrefix\":\"params\"},{\"columnIndex\":\"S_E_CUSTTYPE\",\"columnName\":\"客户类型\",\"columnPrefix\":\"params\"},{\"columnIndex\":\"S_S_CUSTNO\",\"columnName\":\"客户编号\",\"columnPrefix\":\"params\"},{\"columnIndex\":\"runStatus\",\"columnName\":\"运行状态\"},{\"columnIndex\":\"policyDealTypeName\",\"columnName\":\"测试结果\"},{\"columnIndex\":\"operator\",\"columnName\":\"测试人\"}]}', 'admin', 'admin', '策略测试表格配置', 1, 'Json'),
    ('7a5c8d5c398f41f2be6575b6109a680b', '2022-10-17 16:16:07', '2022-10-17 16:16:07', 'outOfTuneDataField', 'S_S_IDNO,S_S_BIZID,C_S_MOBILE', 'admin', 'admin', '尽调数据同步到AS作为开户评级入参字段，英文逗号分隔', 1, 'String'),
    ('alaef22dc7af5cf8b955259f7b1a883a', '2021-11-29 14:00:00', '2022-11-29 11:21:59', 'taskFlowNodeConfig', '{\"1\":[{\"code\":\"start\",\"name\":\"开始\",\"iconText\":\"开始\"},{\"code\":\"end\",\"name\":\"结束\",\"iconText\":\"结束\"},{\"code\":\"data_process\",\"name\":\"数据加工\",\"iconColor\":\"#CFAB67\",\"iconText\":\"数\"},{\"code\":\"account_filter\",\"name\":\"评级账户过滤\",\"iconColor\":\"#54BAA9\",\"iconText\":\"滤\"},{\"code\":\"offline_risk_decision\",\"name\":\"离线决策\",\"iconColor\":\"#5F8DE3\",\"iconText\":\"离\"},{\"code\":\"account_result_send\",\"name\":\"评级结果处理\",\"iconColor\":\"#D37A6D\",\"iconText\":\"评\"},{\"code\":\"offline_metric_backfill\",\"name\":\"指标回溯\",\"iconColor\":\"#9E6FBF\",\"iconText\":\"指\"}],\"default\":[{\"code\":\"start\",\"name\":\"开始\",\"iconText\":\"开始\"},{\"code\":\"end\",\"name\":\"结束\",\"iconText\":\"结束\"},{\"code\":\"data_process\",\"name\":\"数据加工\",\"iconColor\":\"#CFAB67\",\"iconText\":\"数\"},{\"code\":\"offline_risk_decision\",\"name\":\"离线决策\",\"iconColor\":\"#5F8DE3\",\"iconText\":\"离\"},{\"code\":\"offline_metric_backfill\",\"name\":\"指标回溯\",\"iconColor\":\"#9E6FBF\",\"iconText\":\"指\"}]}', '', '', '任务流节点配置参数', 1, 'Json'),
    ('f768fd4d5e1a42ac950991299c621014', '2022-10-18 18:10:15', '2022-10-18 18:10:15', 'useOutOfTuneSync', 'true', 'admin', 'admin', '是否使用开户尽调数据作为开户评级入参', 1, 'Boolean');


DELETE FROM bifrost_system_field WHERE `name`='C_S_PREVIOUSRESULT';
DELETE FROM bifrost_system_field WHERE `name`='C_F_PREVIOUSSCORE';
DELETE FROM bifrost_system_field WHERE `name`='C_S_ACCTCURRRATING';
DELETE FROM bifrost_system_field WHERE `name`='C_S_ACCTCURRTIME';
DELETE FROM bifrost_system_field WHERE `name`='C_S_CONTROLMEASURE';
DELETE FROM bifrost_system_field WHERE `name`='C_S_CURRPERIODRATING';
DELETE FROM bifrost_system_field WHERE `name`='C_S_ACCTCURRPERIODTIME';
DELETE FROM bifrost_system_field WHERE `name`='C_B_ISHITROSTER';
DELETE FROM bifrost_system_field WHERE `name`='C_B_PREISHITROSTER';
DELETE FROM bifrost_system_field WHERE `name`='C_S_CURRENTRATINGRESULT';
DELETE FROM bifrost_system_field WHERE `name`='C_F_CUTTENTRATINGSCORE';
DELETE FROM bifrost_system_field WHERE `name`='C_N_ADDMODE';
DELETE FROM bifrost_system_field WHERE `name`='C_S_CURRENTRESULT';
DELETE FROM bifrost_system_field WHERE `name`='C_S_ACCTLATESTRATING';
DELETE FROM bifrost_system_field WHERE `name`='C_S_ISNEWACCOUNT';
DELETE FROM bifrost_system_field WHERE `name`='C_S_ISUPDACCOUNTINFO';
INSERT INTO `bifrost_system_field` (`uuid`, `display_name`, `name`, `data_type`, `fk_field_group_uuid`, `func_type`, `suffix_name`, `description`, `gmt_create`, `gmt_modified`, `en_display_name`, `encryption_algorithm`, `field_info`, `standard`, `biz_tag`, `for_index`)
VALUES
    ('72e57499-f876-4b69-9ccc-c0904a00e41f', '上期系统评级结果', 'C_S_PREVIOUSRESULT', 1, '83ffbf89-75c4-410d-adec-b9e701251022', 3, 'previousresult', '上期系统评级结果', '2022-08-17 11:46:28', '2022-08-17 11:46:28', NULL, NULL, '', 0, '', 0),
    ('8df9edfc-d3fd-4986-a69b-17630b25c1f3', '上期系统评级分数', 'C_F_PREVIOUSSCORE', 3, '83ffbf89-75c4-410d-adec-b9e701251022', 3, 'previousscore', '上期系统评级分数', '2022-08-17 11:47:36', '2022-08-17 11:47:36', NULL, NULL, '', 0, '', 0),
    ('2980310b-5167-490c-ba2e-49c791918d2d', '账户当前风险评级', 'C_S_ACCTCURRRATING', 1, '83ffbf89-75c4-410d-adec-b9e701251022', 1, 'ACCTCURRRATING', '', '2022-08-18 17:05:46', '2022-08-18 17:05:46', NULL, NULL, '', 0, '', 0),
    ('5697af84-7c17-47c6-82b2-7b688ee5295c', '账户当前评级更新时间', 'C_S_ACCTCURRTIME', 1, '83ffbf89-75c4-410d-adec-b9e701251022', 1, 'ACCTCURRTIME', '', '2022-08-18 17:12:53', '2022-08-18 17:12:53', NULL, NULL, '', 0, '', 0),
    ('dbdc038e-18db-43a8-8b20-0683f6c8b469', '账户管控措施', 'C_S_CONTROLMEASURE', 1, '83ffbf89-75c4-410d-adec-b9e701251022', 1, 'CONTROLMEASURE', '', '2022-08-18 17:11:34', '2022-08-18 17:11:34', NULL, NULL, '', 0, '', 0),
    ('db01f956-3ea8-4885-bac1-15d18001a65d', '账户本期风险评级', 'C_S_CURRPERIODRATING', 1, '83ffbf89-75c4-410d-adec-b9e701251022', 1, 'CURRPERIODRATING', '', '2022-08-18 17:12:28', '2022-08-18 17:12:28', NULL, NULL, '', 0, '', 0),
    ('2bc214d9-fb3d-42d4-a561-a02487f22169', '账户本期评级时间', 'C_S_ACCTCURRPERIODTIME', 1, '83ffbf89-75c4-410d-adec-b9e701251022', 1, 'ACCTCURRPERIODTIME', '', '2022-08-18 17:14:18', '2022-08-18 17:14:18', NULL, NULL, '', 0, '', 0),
    ('f10299c9-60b6-45e5-a144-cc2a7e77245e', '评级是否命中名单', 'C_B_ISHITROSTER', 6, '83ffbf89-75c4-410d-adec-b9e701251022', 3, 'ishitroster', '', '2022-08-22 12:27:18', '2022-08-22 12:27:18', NULL, NULL, '', 0, '', 0),
    ('490727a0-45a2-4258-8409-174e8b720725', '上期评级是否命中名单', 'C_B_PREISHITROSTER', 6, '83ffbf89-75c4-410d-adec-b9e701251022', 3, 'preishitroster', '', '2022-08-22 12:28:07', '2022-08-22 12:28:07', NULL, NULL, '', 0, '', 0),
    ('fb3d8f65-dbba-4399-8d0c-7a0a12724c3f', '本期系统评级结果', 'C_S_CURRENTRATINGRESULT', 1, '83ffbf89-75c4-410d-adec-b9e701251022', 3, 'currentratingresult', '', '2022-08-22 18:34:10', '2022-08-22 18:34:11', NULL, NULL, '', 0, '', 0),
    ('66dc956f-c4cd-4e3d-b310-e19b5751b381', '本期系统评级分数', 'C_F_CUTTENTRATINGSCORE', 3, '83ffbf89-75c4-410d-adec-b9e701251022', 3, 'cuttentratingscore', '', '2022-08-22 12:31:24', '2022-08-22 12:31:24', NULL, NULL, '', 0, '', 0),
    ('3e505f06-2d63-4d73-aae2-a549f391d807', '可疑账户添加方式', 'C_N_ADDMODE', 2, '83ffbf89-75c4-410d-adec-b9e701251022', 1, 'ADDMODE', '', '2022-08-23 10:34:06', '2022-08-23 10:34:06', NULL, NULL, '', 0, '', 0),
    ('a5971d30-1c32-4f9b-ac55-a0bac624d153', '账户当前评级结果', 'C_S_CURRENTRESULT', 1, '83ffbf89-75c4-410d-adec-b9e701251022', 3, 'CURRENTRESULT', '账户当前评级结果', '2022-08-29 20:32:04', '2022-08-29 20:32:04', NULL, NULL, '', 0, '', 0),
    ('75e4814e-1ec2-4d77-b181-26a4b94391c0', '账户开户最近一次尽调结果', 'C_S_ACCTLATESTRATING', 1, '83ffbf89-75c4-410d-adec-b9e701251022', 1, 'ACCTLATESTRATING', '', '2022-09-02 15:55:08', '2022-09-02 15:55:08', NULL, NULL, '', 0, '', 0),
    ('d76843da-2758-4ade-ac60-89163440e760', '是否新增账户', 'C_S_ISNEWACCOUNT', 1, '83ffbf89-75c4-410d-adec-b9e701251022', 1, 'ISNEWACCOUNT', '账户交易滚动评级离线服务必输参数，0-否，1-是', '2022-08-29 20:32:04', '2022-08-29 20:32:04', NULL, NULL, '', 0, '', 0),
    ('7e976a58-0898-495d-a356-f25196a30430', '是否更新账户信息', 'C_S_ISUPDACCOUNTINFO', 1, '83ffbf89-75c4-410d-adec-b9e701251022', 1, 'ISUPDACCOUNTINFO', '账户交易滚动评级离线服务必输参数，0-否，1-是', '2022-08-29 20:32:04', '2022-08-29 20:32:04', NULL, NULL, '', 0, '', 0);


DELETE FROM fiona_flow_form WHERE `code`='3a57241da90b4b7b9ab4ceb71ba41530';
DELETE FROM fiona_flow_form WHERE `code`='488baa02e7d548f7b494028f755333d3';
DELETE FROM fiona_flow_form WHERE `code`='8639d0af2bcd42c6a3ec7bb08242ea9d';
DELETE FROM fiona_flow_form WHERE `code`='a9b67a2566d74496932c278394cbaec3';
INSERT INTO `fiona_flow_form` (`uuid`, `code`, `name`, `type`, `status`, `elements`, `note`, `create_by`, `update_by`, `gmt_create`, `gmt_modify`)
VALUES
    ('63cc41fb39ca4f6da1a515b4a55fab69', '3a57241da90b4b7b9ab4ceb71ba41530', '表单配置示例二', 'basic', 0, '[{\"rowName\":\"行name\",\"children\":[{\"colSpan\":6,\"componentList\":[{\"componentType\":\"text\",\"text\":\"多个选项的操作\",\"textAlign\":\"right\"}]},{\"colSpan\":18,\"componentList\":[{\"name\":\"aa\",\"required\":true,\"editable\":true,\"componentType\":\"input\",\"placeholder\":\"请输入\",\"defaultValue\":null,\"addonBefore\":null,\"addonAfter\":null,\"bizType\":\"input\"},{\"componentType\":\"divider\",\"dashed\":false,\"orientation\":\"center\",\"title\":null},{\"name\":\"bb\",\"required\":true,\"editable\":true,\"componentType\":\"file\",\"bizType\":\"input\",\"placeholder\":\"请输入按钮文字\",\"text\":\"选择文件\"},{\"componentType\":\"divider\",\"dashed\":false,\"orientation\":\"center\",\"title\":null},{\"name\":\"cc\",\"required\":true,\"editable\":true,\"componentType\":\"select\",\"placeholder\":\"请输入\",\"defaultValue\":null,\"mapName\":\"policyBusinessType\",\"bizType\":\"input\"}]}]},{\"rowName\":\"行name\",\"children\":[{\"colSpan\":6,\"componentList\":[{\"componentType\":\"text\",\"text\":\"控件\",\"textAlign\":\"right\"}]},{\"colSpan\":18,\"componentList\":[{\"name\":\"file_a\",\"required\":true,\"editable\":true,\"componentType\":\"file\",\"bizType\":\"input\",\"placeholder\":\"请输入按钮文字\",\"text\":\"选择文件\"}]}]},{\"rowName\":\"行name\",\"children\":[{\"colSpan\":6,\"componentList\":[]},{\"colSpan\":18,\"componentList\":[{\"name\":null,\"text\":\"按钮\",\"block\":false,\"size\":\"default\",\"bizType\":\"audit\",\"componentType\":\"button\",\"type\":\"primary\"},{\"name\":null,\"text\":\"按钮\",\"block\":false,\"size\":\"default\",\"bizType\":\"reject\",\"componentType\":\"button\",\"type\":\"danger\"}]}]}]', '测试', 'admin', 'admin', '2022-09-13 14:57:01', '2022-09-13 15:00:27'),
    ('64eaa3dbc1c444ceb3bf7cff57035a04', '488baa02e7d548f7b494028f755333d3', '内置尽调审核表单', 'basic', 0, '[{\"rowName\":\"行name\",\"children\":[]},{\"rowName\":\"行name\",\"children\":[{\"colSpan\":\"6\",\"componentList\":[]},{\"colSpan\":\"6\",\"componentList\":[{\"componentType\":\"text\",\"text\":\"是否需要认定：\",\"textAlign\":\"right\"}]},{\"colSpan\":6,\"componentList\":[{\"name\":\"isConfirm\",\"required\":true,\"editable\":true,\"componentType\":\"radio\",\"defaultValue\":\"0\",\"buttonStyle\":\"outline\",\"mapName\":\"ifConfirm\",\"bizType\":\"input\"}]}]},{\"rowName\":\"行name\",\"children\":[{\"colSpan\":\"6\",\"componentList\":[]},{\"colSpan\":6,\"componentList\":[]},{\"colSpan\":6,\"componentList\":[{\"name\":null,\"text\":\"转办\",\"block\":false,\"size\":\"default\",\"bizType\":\"turnTo\",\"componentType\":\"button\",\"type\":\"dashed\"},{\"name\":null,\"text\":\"审批\",\"block\":false,\"size\":\"default\",\"bizType\":\"audit\",\"componentType\":\"button\",\"type\":\"primary\"}]}]}]', '', 'admin', 'admin', '2022-09-09 15:32:23', '2022-09-13 19:00:15'),
    ('b45f9c87d65940e897158fa260be10dc', '8639d0af2bcd42c6a3ec7bb08242ea9d', '表单配置示例一', 'basic', 0, '[{\"rowName\":\"行name\",\"children\":[{\"colSpan\":6,\"componentList\":[{\"componentType\":\"text\",\"text\":\"上传\",\"textAlign\":\"right\"}]},{\"colSpan\":18,\"componentList\":[{\"name\":\"file\",\"required\":true,\"editable\":true,\"componentType\":\"file\",\"bizType\":\"input\",\"placeholder\":\"请输入按钮文字\",\"text\":\"请选择文件\"}]}]},{\"rowName\":\"行name\",\"children\":[{\"colSpan\":6,\"componentList\":[{\"componentType\":\"text\",\"text\":\"业务类型\",\"textAlign\":\"right\"}]},{\"colSpan\":18,\"componentList\":[{\"name\":\"type\",\"required\":true,\"editable\":true,\"componentType\":\"select\",\"placeholder\":\"请选择业务类型\",\"defaultValue\":\"\",\"mapName\":\"policyBusinessType\",\"bizType\":\"input\"}]}]},{\"rowName\":\"行name\",\"children\":[{\"colSpan\":6,\"componentList\":[{\"componentType\":\"text\",\"text\":\"开关\",\"textAlign\":\"right\"}]},{\"colSpan\":18,\"componentList\":[{\"name\":\"kaiguan\",\"required\":true,\"editable\":true,\"componentType\":\"switch\",\"defaultValue\":false,\"checkedText\":\"开\",\"unCheckedText\":\"关\",\"size\":\"default\",\"bizType\":\"input\"}]}]},{\"rowName\":\"行name\",\"children\":[{\"colSpan\":6,\"componentList\":[]},{\"colSpan\":18,\"componentList\":[{\"name\":null,\"text\":\"按钮\",\"block\":false,\"size\":\"default\",\"bizType\":\"audit\",\"componentType\":\"button\",\"type\":\"primary\"},{\"name\":null,\"text\":\"按钮\",\"block\":false,\"size\":\"default\",\"bizType\":\"reject\",\"componentType\":\"button\",\"type\":\"danger\"}]}]}]', 'OK', 'admin', 'admin', '2022-09-13 13:58:53', '2022-09-13 14:01:16'),
    ('fe9d19e362694651b884d6c28cb48f0f', 'a9b67a2566d74496932c278394cbaec3', '内置尽调认定表单', 'basic', 0, '[{\"rowName\":\"行name\",\"children\":[{\"colSpan\":\"6\",\"componentList\":[]},{\"colSpan\":\"6\",\"componentList\":[{\"componentType\":\"text\",\"text\":\"审批意见：\",\"textAlign\":\"right\"}]},{\"colSpan\":\"6\",\"componentList\":[{\"name\":\"approvalOpinion\",\"required\":true,\"editable\":true,\"componentType\":\"textarea\",\"defaultValue\":null,\"placeholder\":\"请输入\",\"rows\":\"4\",\"bizType\":\"input\"}]},{\"colSpan\":\"6\",\"componentList\":[]}]},{\"rowName\":\"行name\",\"children\":[{\"colSpan\":\"6\",\"componentList\":[]},{\"colSpan\":\"6\",\"componentList\":[]},{\"colSpan\":\"6\",\"componentList\":[{\"name\":null,\"text\":\"转办\",\"block\":false,\"size\":\"default\",\"bizType\":\"turnTo\",\"componentType\":\"button\",\"type\":\"dashed\"},{\"name\":null,\"text\":\"审批\",\"block\":false,\"size\":\"default\",\"bizType\":\"audit\",\"componentType\":\"button\",\"type\":\"primary\"}]},{\"colSpan\":\"6\",\"componentList\":[]}]}]', '', 'admin', 'admin', '2022-08-29 21:14:49', '2022-08-29 21:16:25');


DELETE FROM fiona_flow_template WHERE `code`='0d2acd7cfbd948f5800b0d9fd710de4a';
DELETE FROM fiona_flow_template WHERE `code`='c515a18aabee4c2ea919ae3a3307b3d4';
INSERT INTO `fiona_flow_template` (`uuid`, `code`, `template`, `name`, `biz_type`, `biz_url`, `status`, `type`, `update_by`, `create_by`, `remark`, `gmt_create`, `gmt_modify`, `version`, `updated_code`, `function_type`, `need_cache`)
VALUES
    ('9d5f8433dd2f4d5aacdbfd7c0ab1092d', '0d2acd7cfbd948f5800b0d9fd710de4a', '{\"edges\":[{\"sourceAnchor\":1,\"targetAnchor\":\"3\",\"source\":\"e8c7b900303011ed962f73238c313caf\",\"target\":\"e97e37c0303011ed962f73238c313caf\",\"labelCfg\":{\"refX\":0,\"refY\":0,\"showNum\":10,\"autoRotate\":false,\"style\":{\"fontSize\":\"12px\",\"fill\":\"#333\",\"stroke\":\"#f0f2f5\"}},\"condition\":\"\",\"defaultCondition\":\"\",\"priority\":\"\",\"label\":\"\"},{\"sourceAnchor\":1,\"targetAnchor\":\"3\",\"source\":\"e97e37c0303011ed962f73238c313caf\",\"target\":\"6c8692d0333711eda63de17f29c42f37\",\"labelCfg\":{\"refX\":0,\"refY\":0,\"showNum\":10,\"autoRotate\":false,\"style\":{\"fontSize\":\"12px\",\"fill\":\"#333\",\"stroke\":\"#f0f2f5\"}},\"condition\":\"\",\"defaultCondition\":\"\",\"priority\":\"\",\"label\":\"\"},{\"sourceAnchor\":2,\"targetAnchor\":\"0\",\"source\":\"6c8692d0333711eda63de17f29c42f37\",\"target\":\"74a5e380333711eda63de17f29c42f37\",\"labelCfg\":{\"refX\":0,\"refY\":0,\"showNum\":10,\"autoRotate\":false,\"style\":{\"fontSize\":\"12px\",\"fill\":\"#333\",\"stroke\":\"#f0f2f5\"}},\"condition\":\"${isConfirm}==0\",\"defaultCondition\":true,\"priority\":\"1\",\"label\":\"不需要认定\"},{\"sourceAnchor\":1,\"targetAnchor\":\"3\",\"source\":\"6c8692d0333711eda63de17f29c42f37\",\"target\":\"c5229c90335511edbab62d65553cc58c\",\"labelCfg\":{\"refX\":0,\"refY\":0,\"showNum\":10,\"autoRotate\":false,\"style\":{\"fontSize\":\"12px\",\"fill\":\"#333\",\"stroke\":\"#f0f2f5\"}},\"condition\":\"${isConfirm}==1\",\"defaultCondition\":\"\",\"priority\":\"3\",\"label\":\"需要认定\"},{\"sourceAnchor\":2,\"targetAnchor\":\"1\",\"source\":\"c5229c90335511edbab62d65553cc58c\",\"target\":\"74a5e380333711eda63de17f29c42f37\",\"labelCfg\":{\"refX\":0,\"refY\":0,\"showNum\":10,\"autoRotate\":false,\"style\":{\"fontSize\":\"12px\",\"fill\":\"#333\",\"stroke\":\"#f0f2f5\"}},\"condition\":\"\",\"defaultCondition\":\"\",\"priority\":\"\",\"label\":\"\"}],\"nodes\":[{\"shape\":\"flow-audit\",\"x\":390,\"y\":266,\"label\":\"审批节点\",\"id\":\"e97e37c0303011ed962f73238c313caf\",\"nodeType\":\"audit\",\"nodeConfig\":{\"type\":\"byHand\",\"formId\":\"64eaa3dbc1c444ceb3bf7cff57035a04\",\"bizUrl\":\"http://10.58.12.192/account/audit/taskDetail?uuid=${uuid}\",\"stage\":null,\"auditBy\":\"upper_org\",\"auditRole\":\"\",\"auditRoleName\":\"\",\"transferRoles\":[],\"auditUser\":\"zhy;zhy2;qian.qiu;test;test2\",\"auditVariable\":\"\",\"auditPattern\":\"normal\",\"overtimeConfig\":{\"time\":6,\"timeUnit\":\"hour\",\"action\":\"pass\",\"transferRole\":null,\"transferRoleName\":null,\"callbackUrl\":null},\"callbackUrl\":\"http://10.58.12.192/accountApi/account/accountOutoftuneTask/check/callback?isConfirm=${isConfirm}\",\"callbackUrlBefore\":null,\"countersignPassRate\":0,\"auditUserName\":\"\"},\"number\":1,\"createTime\":7793305312865359,\"traceNo\":\"0|1\"},{\"shape\":\"flow-exclusivity\",\"x\":620,\"y\":250,\"label\":\"排他\",\"id\":\"6c8692d0333711eda63de17f29c42f37\",\"nodeType\":\"decide\",\"nodeConfig\":{\"countersignPassRate\":0},\"number\":2,\"createTime\":7793305313733230,\"traceNo\":\"0|1|2\"},{\"shape\":\"flow-audit\",\"x\":830,\"y\":266,\"label\":\"审批节点\",\"id\":\"c5229c90335511edbab62d65553cc58c\",\"nodeType\":\"audit\",\"nodeConfig\":{\"type\":\"byHand\",\"formId\":\"fe9d19e362694651b884d6c28cb48f0f\",\"bizUrl\":\"http://10.58.12.192/account/audit/taskDetail?uuid=${uuid}\",\"stageType\":null,\"stage\":null,\"auditBy\":\"upper_org\",\"auditRole\":\"\",\"auditRoleName\":\"\",\"transferRoles\":[],\"auditUser\":\"zhy;zhy2;qian.qiu;siyu.guo\",\"auditVariable\":\"\",\"auditPattern\":\"normal\",\"overtimeConfig\":{\"time\":null,\"timeUnit\":\"hour\",\"action\":\"pass\",\"transferRole\":null,\"transferRoleName\":null,\"callbackUrl\":null},\"callbackUrl\":null,\"callbackUrlBefore\":\"\",\"countersignPassRate\":0,\"auditUserName\":\"\"},\"number\":3,\"createTime\":7793305315956675,\"traceNo\":\"0|1|2|3\"},{\"shape\":\"flow-end\",\"x\":634,\"y\":470,\"label\":\"结束\",\"id\":\"74a5e380333711eda63de17f29c42f37\",\"nodeType\":\"end\",\"nodeConfig\":{\"callbackUrl\":\"http://10.58.12.192/accountApi/account/accountOutoftuneTask/audit/callback?ob=1&isConfirm=${isConfirm}\",\"countersignPassRate\":0},\"number\":4,\"createTime\":7793305316968564,\"traceNo\":\"0|1|2|3|4\"},{\"shape\":\"flow-start\",\"x\":190,\"y\":260,\"label\":\"开始\",\"id\":\"e8c7b900303011ed962f73238c313caf\",\"nodeType\":\"start\",\"nodeConfig\":{\"countersignPassRate\":0},\"number\":0,\"createTime\":7793305311253874,\"traceNo\":0}]}', '内置尽调任务审核认定模版', 'check', 'http://10.59.123.82:8088/account/audit/taskDetail?uuid=${uuid}', 'ONLINE', 0, 'admin', 'admin', '', '2022-09-09 19:16:04', '2022-09-13 19:34:24', 1, '', 'outoftunetask', 0),
    ('ce1829db67ba4d64a5a068d5446a6ad7', 'c515a18aabee4c2ea919ae3a3307b3d4', '{\"edges\":[{\"sourceAnchor\":1,\"targetAnchor\":\"3\",\"source\":\"ca534dc0237b11ed873547a6f37bda26\",\"target\":\"cd181310237b11ed873547a6f37bda26\",\"labelCfg\":{\"refX\":0,\"refY\":0,\"showNum\":10,\"autoRotate\":false,\"style\":{\"fontSize\":\"12px\",\"fill\":\"#333\",\"stroke\":\"#f0f2f5\"}},\"condition\":\"\",\"defaultCondition\":\"\",\"priority\":\"\",\"label\":\"\"},{\"sourceAnchor\":1,\"targetAnchor\":\"3\",\"source\":\"cd181310237b11ed873547a6f37bda26\",\"target\":\"cbee3910237b11ed873547a6f37bda26\",\"labelCfg\":{\"refX\":0,\"refY\":0,\"showNum\":10,\"autoRotate\":false,\"style\":{\"fontSize\":\"12px\",\"fill\":\"#333\",\"stroke\":\"#f0f2f5\"}},\"condition\":\"\",\"defaultCondition\":\"\",\"priority\":\"\",\"label\":\"\"}],\"nodes\":[{\"shape\":\"flow-audit\",\"x\":340,\"y\":197,\"label\":\"审批节点\",\"id\":\"cd181310237b11ed873547a6f37bda26\",\"nodeType\":\"audit\",\"nodeConfig\":{\"type\":\"byHand\",\"formId\":\"fe9d19e362694651b884d6c28cb48f0f\",\"bizUrl\":\"http://10.59.123.82:8088/account/audit/taskDetail?uuid=${uuid}\",\"stageType\":null,\"stage\":null,\"auditBy\":\"upper_org\",\"auditRole\":\"\",\"auditRoleName\":\"\",\"transferRoles\":[],\"auditUser\":\"yong.ding;admin;haiyong.zhang;qingwen.shang;zefei.zhou;qiang.xia;peiran.wang;rong.chen;yunting.bian;changbin.li\",\"auditVariable\":\"\",\"auditPattern\":\"normal\",\"overtimeConfig\":{\"time\":null,\"timeUnit\":\"hour\",\"action\":\"pass\",\"transferRole\":null,\"transferRoleName\":null,\"callbackUrl\":null},\"callbackUrl\":null,\"callbackUrlBefore\":null,\"countersignPassRate\":0,\"auditUserName\":\"\"},\"number\":1,\"createTime\":11401616127010910,\"traceNo\":\"0|1\"},{\"shape\":\"flow-end\",\"x\":610,\"y\":192,\"label\":\"结束\",\"id\":\"cbee3910237b11ed873547a6f37bda26\",\"nodeType\":\"end\",\"nodeConfig\":{\"callbackUrl\":\"http://10.59.123.82:8088/accountApi/account/accountOutoftuneTask/audit/callback?ob=1\",\"countersignPassRate\":0},\"number\":2,\"createTime\":11401616141033132,\"traceNo\":\"0|1|2\"},{\"shape\":\"flow-start\",\"x\":180,\"y\":190,\"label\":\"开始\",\"id\":\"ca534dc0237b11ed873547a6f37bda26\",\"nodeType\":\"start\",\"nodeConfig\":{\"countersignPassRate\":0},\"number\":0,\"createTime\":11401616125548574,\"traceNo\":0}]}', '内置尽调任务认定模版', 'confirm', 'http://10.59.123.82:8088/account/audit/taskDetail?uuid=${uuid}', 'ONLINE', 0, 'admin', 'admin', '', '2022-08-23 14:45:50', '2022-08-29 14:09:43', 1, '', 'outoftuneresult', 0);


DELETE FROM spartan_export_config WHERE `business_type`='risk_rating_export_field';
DELETE FROM spartan_export_config WHERE `business_type`='risk_rating_table_head';
DELETE FROM spartan_export_config WHERE `business_type`='suspicious_export_table_head';
DELETE FROM spartan_export_config WHERE `business_type`='suspicious_table_head';
INSERT INTO `spartan_export_config` (`gmt_create`, `gmt_modified`, `partner_code`, `business_type`, `configs`, `login_id`, `hash`)
VALUES
    ('2023-11-14 16:01:34', '2023-11-14 16:01:34', NULL, 'risk_rating_table_head', '{\"fields\":[{\"field\":\"S_E_CUSTTYPE\",\"fieldName\":\"客户类型\",\"fieldType\":\"ENUM\"},{\"field\":\"S_S_ACCTNO\",\"fieldName\":\"交易账号\",\"fieldType\":\"STRING\"},{\"enFieldName\":\"Account\",\"field\":\"S_S_CUSTNO\",\"fieldName\":\"客户编号\",\"fieldType\":\"STRING\"},{\"field\":\"S_S_CUSTNAME\",\"fieldName\":\"客户名称\",\"fieldType\":\"STRING\"},{\"field\":\"S_S_ORGCODE\",\"fieldName\":\"机构编号\",\"fieldType\":\"STRING\"},{\"field\":\"C_S_ACCTCURRRATING\",\"fieldName\":\"账户当前风险评级\",\"fieldType\":\"ENUM\"},{\"field\":\"C_S_ACCTCURRTIME\",\"fieldName\":\"账户当前评级更新时间\",\"fieldType\":\"STRING\"}]}', 'default', 'dbb5beff09f2fbe5d205df1898b81c5f'),
    ('2023-11-14 16:01:34', '2023-11-14 16:01:34', NULL, 'risk_rating_export_field', '{\"fields\":[{\"field\":\"S_E_CUSTTYPE\",\"fieldName\":\"客户类型\",\"fieldType\":\"ENUM\"},{\"field\":\"S_S_ACCTNO\",\"fieldName\":\"交易账号\",\"fieldType\":\"STRING\"},{\"enFieldName\":\"Account\",\"field\":\"S_S_CUSTNO\",\"fieldName\":\"客户编号\",\"fieldType\":\"STRING\"},{\"field\":\"S_S_CUSTNAME\",\"fieldName\":\"客户名称\",\"fieldType\":\"STRING\"},{\"field\":\"S_S_ORGCODE\",\"fieldName\":\"机构编号\",\"fieldType\":\"STRING\"},{\"field\":\"C_S_ACCTCURRRATING\",\"fieldName\":\"账户当前风险评级\",\"fieldType\":\"ENUM\"},{\"field\":\"C_S_ACCTCURRTIME\",\"fieldName\":\"账户当前评级更新时间\",\"fieldType\":\"STRING\"}]}', 'default', 'dbb5beff09f2fbe5d205df1898b81c5f'),
    ('2023-11-14 16:01:34', '2023-11-14 16:01:34', NULL, 'suspicious_table_head', '{\"fields\":[{\"field\":\"S_E_CUSTTYPE\",\"fieldName\":\"客户类型\",\"fieldType\":\"ENUM\"},{\"field\":\"S_S_ACCTNO\",\"fieldName\":\"交易账号\",\"fieldType\":\"STRING\"},{\"enFieldName\":\"Account\",\"field\":\"S_S_CUSTNO\",\"fieldName\":\"客户编号\",\"fieldType\":\"STRING\"},{\"field\":\"S_S_CUSTNAME\",\"fieldName\":\"客户名称\",\"fieldType\":\"STRING\"},{\"field\":\"S_S_ORGCODE\",\"fieldName\":\"机构编号\",\"fieldType\":\"STRING\"},{\"field\":\"C_S_ACCTCURRRATING\",\"fieldName\":\"账户当前风险评级\",\"fieldType\":\"ENUM\"},{\"field\":\"C_S_ACCTCURRTIME\",\"fieldName\":\"账户当前评级更新时间\",\"fieldType\":\"STRING\"}]}', 'default', 'dbb5beff09f2fbe5d205df1898b81c5f'),
    ('2023-11-14 16:01:35', '2023-11-14 16:01:35', NULL, 'suspicious_export_table_head', '{\"fields\":[{\"field\":\"S_E_CUSTTYPE\",\"fieldName\":\"客户类型\",\"fieldType\":\"ENUM\"},{\"field\":\"S_S_ACCTNO\",\"fieldName\":\"交易账号\",\"fieldType\":\"STRING\"},{\"enFieldName\":\"Account\",\"field\":\"S_S_CUSTNO\",\"fieldName\":\"客户编号\",\"fieldType\":\"STRING\"},{\"field\":\"S_S_CUSTNAME\",\"fieldName\":\"客户名称\",\"fieldType\":\"STRING\"},{\"field\":\"S_S_ORGCODE\",\"fieldName\":\"机构编号\",\"fieldType\":\"STRING\"},{\"field\":\"C_S_ACCTCURRRATING\",\"fieldName\":\"账户当前风险评级\",\"fieldType\":\"ENUM\"},{\"field\":\"C_S_ACCTCURRTIME\",\"fieldName\":\"账户当前评级更新时间\",\"fieldType\":\"STRING\"}]}', 'default', 'dbb5beff09f2fbe5d205df1898b81c5f');


DELETE FROM tiangong_rule_dealtype WHERE `deal_type`='credible';
DELETE FROM tiangong_rule_dealtype WHERE `deal_type`='ordinary';
DELETE FROM tiangong_rule_dealtype WHERE `deal_type`='concerned';
DELETE FROM tiangong_rule_dealtype WHERE `deal_type`='suspicious';
DELETE FROM tiangong_rule_dealtype WHERE `deal_type`='risk';
INSERT INTO `tiangong_rule_dealtype` (`uuid`, `deal_type`, `deal_name`, `grade`, `gmt_create`, `gmt_modify`, `create_by`, `update_by`, `is_default`, `color`)
VALUES
    ('credible', 'credible', '可信账户', 20, '2021-08-31 11:25:41', '2021-11-26 17:11:41', 'xyz', 'admin', 1, '#5AD8A6'),
    ('ordinary', 'ordinary', '普通账户', 10, '2021-08-31 11:33:05', '2021-09-06 19:37:04', 'xyz', 'xyz', 1, '#6DC8EC'),
    ('concerned', 'concerned', '关注账户', 30, '2021-09-06 19:43:24', '2021-09-07 09:31:12', 'xyz', 'xyz', 1, '#F6BD16'),
    ('suspicious', 'suspicious', '可疑账户', 40, '2021-08-31 11:25:41', '2021-11-26 17:11:41', 'xyz', 'admin', 1, '#FF9845'),
    ('risk', 'risk', '风险账户', 50, '2021-08-31 11:33:05', '2021-09-06 19:37:04', 'xyz', 'xyz', 1, '#E86452');


