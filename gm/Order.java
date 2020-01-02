package cn.webank.blockchain.contracts.web3j;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.fisco.bcos.channel.client.TransactionSucCallback;
import org.fisco.bcos.web3j.abi.FunctionEncoder;
import org.fisco.bcos.web3j.abi.FunctionReturnDecoder;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.Address;
import org.fisco.bcos.web3j.abi.datatypes.DynamicArray;
import org.fisco.bcos.web3j.abi.datatypes.Function;
import org.fisco.bcos.web3j.abi.datatypes.Type;
import org.fisco.bcos.web3j.abi.datatypes.Utf8String;
import org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int256;
import org.fisco.bcos.web3j.abi.datatypes.generated.StaticArray16;
import org.fisco.bcos.web3j.abi.datatypes.generated.StaticArray24;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint256;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple1;
import org.fisco.bcos.web3j.tuples.generated.Tuple2;
import org.fisco.bcos.web3j.tuples.generated.Tuple3;
import org.fisco.bcos.web3j.tx.Contract;
import org.fisco.bcos.web3j.tx.TransactionManager;
import org.fisco.bcos.web3j.tx.gas.ContractGasProvider;
import org.fisco.bcos.web3j.tx.txdecode.TransactionDecoder;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.fisco.bcos.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version none.
 */
@SuppressWarnings("unchecked")
public class Order extends Contract {
    public static String BINARY = "60806040523480156200001157600080fd5b50604051602080620018b1833981018060405281019080805190602001909291905050506020604051908101604052806000815250602060405190810160405280600081525081600090805190602001906200006f929190620000f0565b50806001908051906020019062000088929190620000f0565b505050620000a581620000ac640100000000026401000000009004565b506200019f565b80600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106200013357805160ff191683800117855562000164565b8280016001018555821562000164579182015b828111156200016357825182559160200191906001019062000146565b5b50905062000173919062000177565b5090565b6200019c91905b80821115620001985760008160009055506001016200017e565b5090565b90565b61170280620001af6000396000f30060806040526004361061023b576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680630443f0f414610240578063078978cf1461026b578063090f5650146102985780630eb12bee146102c5578063168914d2146102f85780631864fa3a1461032b5780631f9804ec14610358578063235d7f541461038b578063321db474146103be578063393d5c4a146103f15780633c8166171461041c5780633d30969e146104495780633f8cbb141461047457806354de7bf1146104a757806358c6abe1146104d2578063651ed5ce146104fd5780636edd20b71461053e57806371def8b31461056f5780637a1c83aa146106185780637b4832da1461064b5780637e79c0931461068e57806383a018e7146106c1578063858c980e146106f45780638bbeab971461071f5780639a087ea41461074a5780639d8c4c661461077d5780639eaa0c44146107ae578063a6f47af3146107ef578063aa450a3714610838578063abb70c651461086b578063b11b68831461089e578063b40bfca91461092e578063bb5f184b146109be578063c16dc24f146109e9578063c426d16d14610a14578063c7be6a3014610a47578063ce0111f314610a72578063ceac749714610a9f578063d1d9cbbe14610ad2578063d4d7f0f014610b63578063d8fe547614610b96578063d9439aa714610cc5578063db7df39f14610d06578063f4161ef814610d39578063f7c3dc4214610d6c578063f8399de914610d9f578063fb9fd7b514610dd2575b600080fd5b34801561024c57600080fd5b50610255610dfd565b6040518082815260200191505060405180910390f35b34801561027757600080fd5b5061029660048036038101908080359060200190929190505050610e16565b005b3480156102a457600080fd5b506102c360048036038101908080359060200190929190505050610e2f565b005b3480156102d157600080fd5b506102da610e74565b60405180826000191660001916815260200191505060405180910390f35b34801561030457600080fd5b5061030d610e8d565b60405180826000191660001916815260200191505060405180910390f35b34801561033757600080fd5b5061035660048036038101908080359060200190929190505050610ea6565b005b34801561036457600080fd5b5061036d610ebf565b60405180826000191660001916815260200191505060405180910390f35b34801561039757600080fd5b506103a0610ed8565b60405180826000191660001916815260200191505060405180910390f35b3480156103ca57600080fd5b506103d3610ef0565b60405180826000191660001916815260200191505060405180910390f35b3480156103fd57600080fd5b50610406610f09565b6040518082815260200191505060405180910390f35b34801561042857600080fd5b5061044760048036038101908080359060200190929190505050610f16565b005b34801561045557600080fd5b5061045e610f2f565b6040518082815260200191505060405180910390f35b34801561048057600080fd5b50610489610f48565b60405180826000191660001916815260200191505060405180910390f35b3480156104b357600080fd5b506104bc610f61565b6040518082815260200191505060405180910390f35b3480156104de57600080fd5b506104e7610f7a565b6040518082815260200191505060405180910390f35b34801561050957600080fd5b5061052860048036038101908080359060200190929190505050610f93565b6040518082815260200191505060405180910390f35b34801561054a57600080fd5b5061056d6004803603810190808035600019169060200190929190505050610fb1565b005b34801561057b57600080fd5b506106166004803603810190808035906020019082018035906020019080806020026020016040519081016040528093929190818152602001838360200280828437820191505050505050919291929080359060200190820180359060200190808060200260200160405190810160405280939291908181526020018383602002808284378201915050505050509192919290505050610fbf565b005b34801561062457600080fd5b5061062d61105a565b60405180826000191660001916815260200191505060405180910390f35b34801561065757600080fd5b5061068c600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050611073565b005b34801561069a57600080fd5b506106a36110b7565b60405180826000191660001916815260200191505060405180910390f35b3480156106cd57600080fd5b506106d66110d0565b60405180826000191660001916815260200191505060405180910390f35b34801561070057600080fd5b506107096110e9565b6040518082815260200191505060405180910390f35b34801561072b57600080fd5b50610734611102565b6040518082815260200191505060405180910390f35b34801561075657600080fd5b5061075f61111b565b60405180826000191660001916815260200191505060405180910390f35b34801561078957600080fd5b506107ac6004803603810190808035600019169060200190929190505050611134565b005b3480156107ba57600080fd5b506107d960048036038101908080359060200190929190505050611151565b6040518082815260200191505060405180910390f35b3480156107fb57600080fd5b5061081a60048036038101908080359060200190929190505050611174565b60405180826000191660001916815260200191505060405180910390f35b34801561084457600080fd5b5061084d61118e565b60405180826000191660001916815260200191505060405180910390f35b34801561087757600080fd5b506108806111a7565b60405180826000191660001916815260200191505060405180910390f35b3480156108aa57600080fd5b506108b36111c0565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156108f35780820151818401526020810190506108d8565b50505050905090810190601f1680156109205780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561093a57600080fd5b5061094361125e565b6040518080602001828103825283818151815260200191508051906020019080838360005b83811015610983578082015181840152602081019050610968565b50505050905090810190601f1680156109b05780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b3480156109ca57600080fd5b506109d36112fc565b6040518082815260200191505060405180910390f35b3480156109f557600080fd5b506109fe61133d565b6040518082815260200191505060405180910390f35b348015610a2057600080fd5b50610a29611356565b60405180826000191660001916815260200191505060405180910390f35b348015610a5357600080fd5b50610a5c61136f565b6040518082815260200191505060405180910390f35b348015610a7e57600080fd5b50610a9d60048036038101908080359060200190929190505050611388565b005b348015610aab57600080fd5b50610ab46113a1565b60405180826000191660001916815260200191505060405180910390f35b348015610ade57600080fd5b50610ae76113ba565b60405180846000191660001916815260200183601860200280838360005b83811015610b20578082015181840152602081019050610b05565b5050505090500182601060200280838360005b83811015610b4e578082015181840152602081019050610b33565b50505050905001935050505060405180910390f35b348015610b6f57600080fd5b50610b78611483565b60405180826000191660001916815260200191505060405180910390f35b348015610ba257600080fd5b50610bab61149c565b6040518080602001806020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001838103835286818151815260200191508051906020019080838360005b83811015610c21578082015181840152602081019050610c06565b50505050905090810190601f168015610c4e5780820380516001836020036101000a031916815260200191505b50838103825285818151815260200191508051906020019080838360005b83811015610c87578082015181840152602081019050610c6c565b50505050905090810190601f168015610cb45780820380516001836020036101000a031916815260200191505b509550505050505060405180910390f35b348015610cd157600080fd5b50610cf06004803603810190808035906020019092919050505061160a565b6040518082815260200191505060405180910390f35b348015610d1257600080fd5b50610d1b611624565b60405180826000191660001916815260200191505060405180910390f35b348015610d4557600080fd5b50610d4e61163d565b60405180826000191660001916815260200191505060405180910390f35b348015610d7857600080fd5b50610d81611643565b60405180826000191660001916815260200191505060405180910390f35b348015610dab57600080fd5b50610db461165c565b60405180826000191660001916815260200191505060405180910390f35b348015610dde57600080fd5b50610de7611675565b6040518082815260200191505060405180910390f35b6000601b6007601081101515610e0f57fe5b0154905090565b80601b6005601081101515610e2757fe5b018190555050565b602c81908060018154018082558091505090600182039060005260206000200160009091929091909150555080601b6008601081101515610e6c57fe5b018190555050565b60006003600f601881101515610e8657fe5b0154905090565b600060036009601881101515610e9f57fe5b0154905090565b80601b6004601081101515610eb757fe5b018190555050565b600060036008601881101515610ed157fe5b0154905090565b6000600380601881101515610ee957fe5b0154905090565b600060036004601881101515610f0257fe5b0154905090565b6000602c80549050905090565b80601b6003601081101515610f2757fe5b018190555050565b6000601b6000601081101515610f4157fe5b0154905090565b600060036001601881101515610f5a57fe5b0154905090565b6000601b6004601081101515610f7357fe5b0154905090565b6000601b6003601081101515610f8c57fe5b0154905090565b600081601b6001601081101515610fa657fe5b018190559050919050565b80602b816000191690555050565b600080600091505b601882101561100d578382815181101515610fde57fe5b90602001906020020151600383601881101515610ff757fe5b0181600019169055508180600101925050610fc7565b600090505b601081101561105457828181518110151561102957fe5b90602001906020020151601b8260108110151561104257fe5b01819055508080600101915050611012565b50505050565b60006003600e60188110151561106c57fe5b0154905090565b80600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b6000600360006018811015156110c957fe5b0154905090565b6000600360116018811015156110e257fe5b0154905090565b6000601b60026010811015156110fb57fe5b0154905090565b6000601b600960108110151561111457fe5b0154905090565b60006003600d60188110151561112d57fe5b0154905090565b806003600f60188110151561114557fe5b01816000191690555050565b602c8181548110151561116057fe5b906000526020600020016000915090505481565b60038160188110151561118357fe5b016000915090505481565b6000600360056018811015156111a057fe5b0154905090565b6000600360076018811015156111b957fe5b0154905090565b60008054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156112565780601f1061122b57610100808354040283529160200191611256565b820191906000526020600020905b81548152906001019060200180831161123957829003601f168201915b505050505081565b60018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156112f45780601f106112c9576101008083540402835291602001916112f4565b820191906000526020600020905b8154815290600101906020018083116112d757829003601f168201915b505050505081565b600080602c80549050111515611315576000905061133a565b602c6001602c805490500381548110151561132c57fe5b906000526020600020015490505b90565b6000601b600160108110151561134f57fe5b0154905090565b60006003600b60188110151561136857fe5b0154905090565b6000601b600660108110151561138157fe5b0154905090565b80601b600960108110151561139957fe5b018190555050565b6000600360066018811015156113b357fe5b0154905090565b60006113c461168e565b6113cc6116b2565b6113d461168e565b60006113de6116b2565b60008092505b601883101561142c576003836018811015156113fc57fe5b0154848460188110151561140c57fe5b6020020190600019169081600019168152505082806001019350506113e4565b600090505b601081101561146f57601b8160108110151561144957fe5b0154828260108110151561145957fe5b6020020181815250508080600101915050611431565b602b54848396509650965050505050909192565b60006003600260188110151561149557fe5b0154905090565b6060806000806001600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16828054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561155c5780601f106115315761010080835404028352916020019161155c565b820191906000526020600020905b81548152906001019060200180831161153f57829003601f168201915b50505050509250818054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156115f85780601f106115cd576101008083540402835291602001916115f8565b820191906000526020600020905b8154815290600101906020018083116115db57829003601f168201915b50505050509150925092509250909192565b601b8160108110151561161957fe5b016000915090505481565b60006003600a60188110151561163657fe5b0154905090565b602b5481565b60006003600c60188110151561165557fe5b0154905090565b60006003601060188110151561166e57fe5b0154905090565b6000601b600560108110151561168757fe5b0154905090565b61030060405190810160405280601890602082028038833980820191505090505090565b610200604051908101604052806010906020820280388339808201915050905050905600a165627a7a72305820936f42681c57d6374c0902dc24693fb49278f71c46fdf262576724ab4d114b720029";

    public static final String ABI = "[{\"constant\":true,\"inputs\":[],\"name\":\"tradeTypeValue\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_fxRate\",\"type\":\"int256\"}],\"name\":\"setFxRate\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_txStatus\",\"type\":\"int256\"}],\"name\":\"setTxStatus\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"mccCode\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"reportCity\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_currency\",\"type\":\"int256\"}],\"name\":\"setCurrency\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"userAppIp\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"orgBizNo\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"userAccount\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[],\"name\":\"txStatusListSize\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_txAmt\",\"type\":\"int256\"}],\"name\":\"setTxAmt\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"txType\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"abBizNo\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"currency\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"txAmt\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_isRefunded\",\"type\":\"int256\"}],\"name\":\"setIsRefunded\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_date\",\"type\":\"bytes32\"}],\"name\":\"setDate\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"bytesArrParam\",\"type\":\"bytes32[]\"},{\"name\":\"intArrParam\",\"type\":\"int256[]\"}],\"name\":\"initOrder\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"merchantOrgCode\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"meta\",\"type\":\"address\"}],\"name\":\"setMetaAddress\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"ibBizNo\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"storeId\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"rmbAmt\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"checkCode\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"merchantName\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_txTime\",\"type\":\"bytes32\"}],\"name\":\"setTxTime\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"name\":\"txStatusList\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"name\":\"bytes32Arr\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"userName\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"toOrgId\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"name\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"abi\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[],\"name\":\"txStatus\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"isRefunded\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"merchantSvcName\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"exTimestamp\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_checkCode\",\"type\":\"int256\"}],\"name\":\"setCheckCode\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"fromOrgId\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getAllFields\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"},{\"name\":\"\",\"type\":\"bytes32[24]\"},{\"name\":\"\",\"type\":\"int256[16]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"msBizNo\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getMeta\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"name\":\"intArr\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"merchantSvcId\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"date\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"merchantId\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"txTime\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"fxRate\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"inputs\":[{\"name\":\"meta\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"}]";

    public static final TransactionDecoder transactionDecoder = new TransactionDecoder(ABI, BINARY);

    public static final String FUNC_TRADETYPEVALUE = "tradeTypeValue";

    public static final String FUNC_SETFXRATE = "setFxRate";

    public static final String FUNC_SETTXSTATUS = "setTxStatus";

    public static final String FUNC_MCCCODE = "mccCode";

    public static final String FUNC_REPORTCITY = "reportCity";

    public static final String FUNC_SETCURRENCY = "setCurrency";

    public static final String FUNC_USERAPPIP = "userAppIp";

    public static final String FUNC_ORGBIZNO = "orgBizNo";

    public static final String FUNC_USERACCOUNT = "userAccount";

    public static final String FUNC_TXSTATUSLISTSIZE = "txStatusListSize";

    public static final String FUNC_SETTXAMT = "setTxAmt";

    public static final String FUNC_TXTYPE = "txType";

    public static final String FUNC_ABBIZNO = "abBizNo";

    public static final String FUNC_CURRENCY = "currency";

    public static final String FUNC_TXAMT = "txAmt";

    public static final String FUNC_SETISREFUNDED = "setIsRefunded";

    public static final String FUNC_SETDATE = "setDate";

    public static final String FUNC_INITORDER = "initOrder";

    public static final String FUNC_MERCHANTORGCODE = "merchantOrgCode";

    public static final String FUNC_SETMETAADDRESS = "setMetaAddress";

    public static final String FUNC_IBBIZNO = "ibBizNo";

    public static final String FUNC_STOREID = "storeId";

    public static final String FUNC_RMBAMT = "rmbAmt";

    public static final String FUNC_CHECKCODE = "checkCode";

    public static final String FUNC_MERCHANTNAME = "merchantName";

    public static final String FUNC_SETTXTIME = "setTxTime";

    public static final String FUNC_TXSTATUSLIST = "txStatusList";

    public static final String FUNC_BYTES32ARR = "bytes32Arr";

    public static final String FUNC_USERNAME = "userName";

    public static final String FUNC_TOORGID = "toOrgId";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_ABI = "abi";

    public static final String FUNC_TXSTATUS = "txStatus";

    public static final String FUNC_ISREFUNDED = "isRefunded";

    public static final String FUNC_MERCHANTSVCNAME = "merchantSvcName";

    public static final String FUNC_EXTIMESTAMP = "exTimestamp";

    public static final String FUNC_SETCHECKCODE = "setCheckCode";

    public static final String FUNC_FROMORGID = "fromOrgId";

    public static final String FUNC_GETALLFIELDS = "getAllFields";

    public static final String FUNC_MSBIZNO = "msBizNo";

    public static final String FUNC_GETMETA = "getMeta";

    public static final String FUNC_INTARR = "intArr";

    public static final String FUNC_MERCHANTSVCID = "merchantSvcId";

    public static final String FUNC_DATE = "date";

    public static final String FUNC_MERCHANTID = "merchantId";

    public static final String FUNC_TXTIME = "txTime";

    public static final String FUNC_FXRATE = "fxRate";

    @Deprecated
    protected Order(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Order(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Order(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Order(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static TransactionDecoder getTransactionDecoder() {
        return transactionDecoder;
    }

    public RemoteCall<BigInteger> tradeTypeValue() {
        final Function function = new Function(FUNC_TRADETYPEVALUE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> setFxRate(BigInteger _fxRate) {
        final Function function = new Function(
                FUNC_SETFXRATE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(_fxRate)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setFxRate(BigInteger _fxRate, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETFXRATE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(_fxRate)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setFxRateSeq(BigInteger _fxRate) {
        final Function function = new Function(
                FUNC_SETFXRATE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(_fxRate)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<BigInteger> getSetFxRateInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETFXRATE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> setTxStatus(BigInteger _txStatus) {
        final Function function = new Function(
                FUNC_SETTXSTATUS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(_txStatus)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setTxStatus(BigInteger _txStatus, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETTXSTATUS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(_txStatus)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setTxStatusSeq(BigInteger _txStatus) {
        final Function function = new Function(
                FUNC_SETTXSTATUS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(_txStatus)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<BigInteger> getSetTxStatusInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETTXSTATUS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public RemoteCall<byte[]> mccCode() {
        final Function function = new Function(FUNC_MCCCODE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<byte[]> reportCity() {
        final Function function = new Function(FUNC_REPORTCITY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<TransactionReceipt> setCurrency(BigInteger _currency) {
        final Function function = new Function(
                FUNC_SETCURRENCY, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(_currency)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setCurrency(BigInteger _currency, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETCURRENCY, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(_currency)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setCurrencySeq(BigInteger _currency) {
        final Function function = new Function(
                FUNC_SETCURRENCY, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(_currency)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<BigInteger> getSetCurrencyInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETCURRENCY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public RemoteCall<byte[]> userAppIp() {
        final Function function = new Function(FUNC_USERAPPIP, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<byte[]> orgBizNo() {
        final Function function = new Function(FUNC_ORGBIZNO, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<byte[]> userAccount() {
        final Function function = new Function(FUNC_USERACCOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<TransactionReceipt> txStatusListSize() {
        final Function function = new Function(
                FUNC_TXSTATUSLISTSIZE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void txStatusListSize(TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_TXSTATUSLISTSIZE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String txStatusListSizeSeq() {
        final Function function = new Function(
                FUNC_TXSTATUSLISTSIZE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<BigInteger> getTxStatusListSizeOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_TXSTATUSLISTSIZE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> setTxAmt(BigInteger _txAmt) {
        final Function function = new Function(
                FUNC_SETTXAMT, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(_txAmt)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setTxAmt(BigInteger _txAmt, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETTXAMT, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(_txAmt)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setTxAmtSeq(BigInteger _txAmt) {
        final Function function = new Function(
                FUNC_SETTXAMT, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(_txAmt)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<BigInteger> getSetTxAmtInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETTXAMT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public RemoteCall<BigInteger> txType() {
        final Function function = new Function(FUNC_TXTYPE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<byte[]> abBizNo() {
        final Function function = new Function(FUNC_ABBIZNO, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<BigInteger> currency() {
        final Function function = new Function(FUNC_CURRENCY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> txAmt() {
        final Function function = new Function(FUNC_TXAMT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> setIsRefunded(BigInteger _isRefunded) {
        final Function function = new Function(
                FUNC_SETISREFUNDED, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(_isRefunded)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setIsRefunded(BigInteger _isRefunded, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETISREFUNDED, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(_isRefunded)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setIsRefundedSeq(BigInteger _isRefunded) {
        final Function function = new Function(
                FUNC_SETISREFUNDED, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(_isRefunded)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<BigInteger> getSetIsRefundedInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETISREFUNDED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public Tuple1<BigInteger> getSetIsRefundedOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_SETISREFUNDED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> setDate(byte[] _date) {
        final Function function = new Function(
                FUNC_SETDATE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(_date)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setDate(byte[] _date, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETDATE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(_date)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setDateSeq(byte[] _date) {
        final Function function = new Function(
                FUNC_SETDATE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(_date)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<byte[]> getSetDateInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETDATE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<byte[]>(

                (byte[]) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> initOrder(List<byte[]> bytesArrParam, List<BigInteger> intArrParam) {
        final Function function = new Function(
                FUNC_INITORDER, 
                Arrays.<Type>asList(bytesArrParam.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("bytes32[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(bytesArrParam, org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32.class)), 
                intArrParam.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("int256[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Int256>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(intArrParam, org.fisco.bcos.web3j.abi.datatypes.generated.Int256.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void initOrder(List<byte[]> bytesArrParam, List<BigInteger> intArrParam, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_INITORDER, 
                Arrays.<Type>asList(bytesArrParam.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("bytes32[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(bytesArrParam, org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32.class)), 
                intArrParam.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("int256[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Int256>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(intArrParam, org.fisco.bcos.web3j.abi.datatypes.generated.Int256.class))), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String initOrderSeq(List<byte[]> bytesArrParam, List<BigInteger> intArrParam) {
        final Function function = new Function(
                FUNC_INITORDER, 
                Arrays.<Type>asList(bytesArrParam.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("bytes32[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(bytesArrParam, org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32.class)), 
                intArrParam.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("int256[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Int256>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(intArrParam, org.fisco.bcos.web3j.abi.datatypes.generated.Int256.class))), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<List<byte[]>, List<BigInteger>> getInitOrderInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_INITORDER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Bytes32>>() {}, new TypeReference<DynamicArray<Int256>>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<List<byte[]>, List<BigInteger>>(

                convertToNative((List<Bytes32>) results.get(0).getValue()), 
                convertToNative((List<Int256>) results.get(1).getValue())
                );
    }

    public RemoteCall<byte[]> merchantOrgCode() {
        final Function function = new Function(FUNC_MERCHANTORGCODE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<TransactionReceipt> setMetaAddress(String meta) {
        final Function function = new Function(
                FUNC_SETMETAADDRESS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(meta)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setMetaAddress(String meta, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETMETAADDRESS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(meta)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setMetaAddressSeq(String meta) {
        final Function function = new Function(
                FUNC_SETMETAADDRESS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(meta)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<String> getSetMetaAddressInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETMETAADDRESS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public RemoteCall<byte[]> ibBizNo() {
        final Function function = new Function(FUNC_IBBIZNO, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<byte[]> storeId() {
        final Function function = new Function(FUNC_STOREID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<BigInteger> rmbAmt() {
        final Function function = new Function(FUNC_RMBAMT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> checkCode() {
        final Function function = new Function(FUNC_CHECKCODE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<byte[]> merchantName() {
        final Function function = new Function(FUNC_MERCHANTNAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<TransactionReceipt> setTxTime(byte[] _txTime) {
        final Function function = new Function(
                FUNC_SETTXTIME, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(_txTime)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setTxTime(byte[] _txTime, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETTXTIME, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(_txTime)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setTxTimeSeq(byte[] _txTime) {
        final Function function = new Function(
                FUNC_SETTXTIME, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(_txTime)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<byte[]> getSetTxTimeInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETTXTIME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<byte[]>(

                (byte[]) results.get(0).getValue()
                );
    }

    public RemoteCall<BigInteger> txStatusList(BigInteger param0) {
        final Function function = new Function(FUNC_TXSTATUSLIST, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<byte[]> bytes32Arr(BigInteger param0) {
        final Function function = new Function(FUNC_BYTES32ARR, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<byte[]> userName() {
        final Function function = new Function(FUNC_USERNAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<byte[]> toOrgId() {
        final Function function = new Function(FUNC_TOORGID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<String> name() {
        final Function function = new Function(FUNC_NAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> abi() {
        final Function function = new Function(FUNC_ABI, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> txStatus() {
        final Function function = new Function(
                FUNC_TXSTATUS, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void txStatus(TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_TXSTATUS, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String txStatusSeq() {
        final Function function = new Function(
                FUNC_TXSTATUS, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<BigInteger> getTxStatusOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_TXSTATUS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public RemoteCall<BigInteger> isRefunded() {
        final Function function = new Function(FUNC_ISREFUNDED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<byte[]> merchantSvcName() {
        final Function function = new Function(FUNC_MERCHANTSVCNAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<BigInteger> exTimestamp() {
        final Function function = new Function(FUNC_EXTIMESTAMP, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> setCheckCode(BigInteger _checkCode) {
        final Function function = new Function(
                FUNC_SETCHECKCODE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(_checkCode)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setCheckCode(BigInteger _checkCode, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETCHECKCODE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(_checkCode)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setCheckCodeSeq(BigInteger _checkCode) {
        final Function function = new Function(
                FUNC_SETCHECKCODE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(_checkCode)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<BigInteger> getSetCheckCodeInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETCHECKCODE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public RemoteCall<byte[]> fromOrgId() {
        final Function function = new Function(FUNC_FROMORGID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<Tuple3<byte[], List<byte[]>, List<BigInteger>>> getAllFields() {
        final Function function = new Function(FUNC_GETALLFIELDS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<StaticArray24<Bytes32>>() {}, new TypeReference<StaticArray16<Int256>>() {}));
        return new RemoteCall<Tuple3<byte[], List<byte[]>, List<BigInteger>>>(
                new Callable<Tuple3<byte[], List<byte[]>, List<BigInteger>>>() {
                    @Override
                    public Tuple3<byte[], List<byte[]>, List<BigInteger>> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<byte[], List<byte[]>, List<BigInteger>>(
                                (byte[]) results.get(0).getValue(), 
                                convertToNative((List<Bytes32>) results.get(1).getValue()), 
                                convertToNative((List<Int256>) results.get(2).getValue()));
                    }
                });
    }

    public RemoteCall<byte[]> msBizNo() {
        final Function function = new Function(FUNC_MSBIZNO, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<Tuple3<String, String, String>> getMeta() {
        final Function function = new Function(FUNC_GETMETA, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}));
        return new RemoteCall<Tuple3<String, String, String>>(
                new Callable<Tuple3<String, String, String>>() {
                    @Override
                    public Tuple3<String, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<String, String, String>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue());
                    }
                });
    }

    public RemoteCall<BigInteger> intArr(BigInteger param0) {
        final Function function = new Function(FUNC_INTARR, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<byte[]> merchantSvcId() {
        final Function function = new Function(FUNC_MERCHANTSVCID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<byte[]> date() {
        final Function function = new Function(FUNC_DATE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<byte[]> merchantId() {
        final Function function = new Function(FUNC_MERCHANTID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<byte[]> txTime() {
        final Function function = new Function(FUNC_TXTIME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<BigInteger> fxRate() {
        final Function function = new Function(FUNC_FXRATE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static Order load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Order(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Order load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Order(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Order load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Order(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Order load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Order(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Order> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String meta) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(meta)));
        return deployRemoteCall(Order.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<Order> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String meta) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(meta)));
        return deployRemoteCall(Order.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Order> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String meta) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(meta)));
        return deployRemoteCall(Order.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Order> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String meta) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(meta)));
        return deployRemoteCall(Order.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
