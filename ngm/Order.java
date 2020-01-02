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
    public static String BINARY = "60806040523480156200001157600080fd5b50604051602080620018b1833981018060405281019080805190602001909291905050506020604051908101604052806000815250602060405190810160405280600081525081600090805190602001906200006f929190620000f0565b50806001908051906020019062000088929190620000f0565b505050620000a581620000ac640100000000026401000000009004565b506200019f565b80600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106200013357805160ff191683800117855562000164565b8280016001018555821562000164579182015b828111156200016357825182559160200191906001019062000146565b5b50905062000173919062000177565b5090565b6200019c91905b80821115620001985760008160009055506001016200017e565b5090565b90565b61170280620001af6000396000f30060806040526004361061023b576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680630113c0b214610240578063068635e01461026b57806306a7983d1461029e57806306fdde03146102df5780630768923f1461036f57806310ae4c8d146103a25780631166b54b146103cd57806312f33a40146104105780631a6c779b1461044357806326941053146104705780632722b3111461049b5780632b181022146104ce578063323046b1146104fb57806333d2c9541461052e57806338d0694214610559578063405f50f11461058457806347ee6a07146105b7578063484787f4146105ea578063488706301461061d5780634be39b69146106ad5780634da8f356146106e05780634e41c9de1461070b5780634e4278521461073e57806353294bfc14610771578063566caa4b1461081a578063598b0a2f1461084d578063681dc055146108805780636ad87519146108b157806370019b35146108dc578063779cd0831461090f578063922082281461093a57806393016e74146109cb578063a2d69ad5146109f8578063a464e5ab14610a2b578063a79af2ce14610a5e578063abda23d314610b8d578063aec2b87914610bbe578063b574cf5514610bff578063c168236414610c32578063c8e2b4dd14610c5d578063cbed176d14610c8a578063d9c973e214610cd3578063e1676eab14610d06578063e5a6b10f14610d31578063e73ccd5c14610d5c578063ea8d272014610d9d578063ec86cda814610dca575b600080fd5b34801561024c57600080fd5b50610255610dfd565b6040518082815260200191505060405180910390f35b34801561027757600080fd5b50610280610e16565b60405180826000191660001916815260200191505060405180910390f35b3480156102aa57600080fd5b506102c960048036038101908080359060200190929190505050610e2f565b6040518082815260200191505060405180910390f35b3480156102eb57600080fd5b506102f4610e49565b6040518080602001828103825283818151815260200191508051906020019080838360005b83811015610334578082015181840152602081019050610319565b50505050905090810190601f1680156103615780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561037b57600080fd5b50610384610ee7565b60405180826000191660001916815260200191505060405180910390f35b3480156103ae57600080fd5b506103b7610f00565b6040518082815260200191505060405180910390f35b3480156103d957600080fd5b5061040e600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610f19565b005b34801561041c57600080fd5b50610425610f5d565b60405180826000191660001916815260200191505060405180910390f35b34801561044f57600080fd5b5061046e60048036038101908080359060200190929190505050610f76565b005b34801561047c57600080fd5b50610485610f8f565b6040518082815260200191505060405180910390f35b3480156104a757600080fd5b506104b0610fa8565b60405180826000191660001916815260200191505060405180910390f35b3480156104da57600080fd5b506104f960048036038101908080359060200190929190505050610fc1565b005b34801561050757600080fd5b50610510611006565b60405180826000191660001916815260200191505060405180910390f35b34801561053a57600080fd5b5061054361100c565b6040518082815260200191505060405180910390f35b34801561056557600080fd5b5061056e611025565b6040518082815260200191505060405180910390f35b34801561059057600080fd5b50610599611032565b60405180826000191660001916815260200191505060405180910390f35b3480156105c357600080fd5b506105cc61104b565b60405180826000191660001916815260200191505060405180910390f35b3480156105f657600080fd5b506105ff611064565b60405180826000191660001916815260200191505060405180910390f35b34801561062957600080fd5b5061063261107d565b6040518080602001828103825283818151815260200191508051906020019080838360005b83811015610672578082015181840152602081019050610657565b50505050905090810190601f16801561069f5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b3480156106b957600080fd5b506106c261111b565b60405180826000191660001916815260200191505060405180910390f35b3480156106ec57600080fd5b506106f5611134565b6040518082815260200191505060405180910390f35b34801561071757600080fd5b5061072061114d565b60405180826000191660001916815260200191505060405180910390f35b34801561074a57600080fd5b50610753611166565b60405180826000191660001916815260200191505060405180910390f35b34801561077d57600080fd5b50610818600480360381019080803590602001908201803590602001908080602002602001604051908101604052809392919081815260200183836020028082843782019150505050505091929192908035906020019082018035906020019080806020026020016040519081016040528093929190818152602001838360200280828437820191505050505050919291929050505061117f565b005b34801561082657600080fd5b5061082f61121a565b60405180826000191660001916815260200191505060405180910390f35b34801561085957600080fd5b50610862611233565b60405180826000191660001916815260200191505060405180910390f35b34801561088c57600080fd5b506108af600480360381019080803560001916906020019092919050505061124b565b005b3480156108bd57600080fd5b506108c6611259565b6040518082815260200191505060405180910390f35b3480156108e857600080fd5b506108f1611272565b60405180826000191660001916815260200191505060405180910390f35b34801561091b57600080fd5b5061092461128b565b6040518082815260200191505060405180910390f35b34801561094657600080fd5b5061094f6112a4565b60405180846000191660001916815260200183601860200280838360005b8381101561098857808201518184015260208101905061096d565b5050505090500182601060200280838360005b838110156109b657808201518184015260208101905061099b565b50505050905001935050505060405180910390f35b3480156109d757600080fd5b506109f66004803603810190808035906020019092919050505061136d565b005b348015610a0457600080fd5b50610a0d611386565b60405180826000191660001916815260200191505060405180910390f35b348015610a3757600080fd5b50610a4061139f565b60405180826000191660001916815260200191505060405180910390f35b348015610a6a57600080fd5b50610a736113b8565b6040518080602001806020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001838103835286818151815260200191508051906020019080838360005b83811015610ae9578082015181840152602081019050610ace565b50505050905090810190601f168015610b165780820380516001836020036101000a031916815260200191505b50838103825285818151815260200191508051906020019080838360005b83811015610b4f578082015181840152602081019050610b34565b50505050905090810190601f168015610b7c5780820380516001836020036101000a031916815260200191505b509550505050505060405180910390f35b348015610b9957600080fd5b50610bbc6004803603810190808035600019169060200190929190505050611526565b005b348015610bca57600080fd5b50610be960048036038101908080359060200190929190505050611543565b6040518082815260200191505060405180910390f35b348015610c0b57600080fd5b50610c14611561565b60405180826000191660001916815260200191505060405180910390f35b348015610c3e57600080fd5b50610c4761157a565b6040518082815260200191505060405180910390f35b348015610c6957600080fd5b50610c88600480360381019080803590602001909291905050506115bb565b005b348015610c9657600080fd5b50610cb5600480360381019080803590602001909291905050506115d4565b60405180826000191660001916815260200191505060405180910390f35b348015610cdf57600080fd5b50610ce86115ee565b60405180826000191660001916815260200191505060405180910390f35b348015610d1257600080fd5b50610d1b611607565b6040518082815260200191505060405180910390f35b348015610d3d57600080fd5b50610d46611620565b6040518082815260200191505060405180910390f35b348015610d6857600080fd5b50610d8760048036038101908080359060200190929190505050611639565b6040518082815260200191505060405180910390f35b348015610da957600080fd5b50610dc86004803603810190808035906020019092919050505061165c565b005b348015610dd657600080fd5b50610ddf611675565b60405180826000191660001916815260200191505060405180910390f35b6000601b6002601081101515610e0f57fe5b0154905090565b60006003600a601881101515610e2857fe5b0154905090565b601b81601081101515610e3e57fe5b016000915090505481565b60008054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610edf5780601f10610eb457610100808354040283529160200191610edf565b820191906000526020600020905b815481529060010190602001808311610ec257829003601f168201915b505050505081565b600060036002601881101515610ef957fe5b0154905090565b6000601b6009601081101515610f1257fe5b0154905090565b80600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b60006003600c601881101515610f6f57fe5b0154905090565b80601b6005601081101515610f8757fe5b018190555050565b6000601b6003601081101515610fa157fe5b0154905090565b60006003600b601881101515610fba57fe5b0154905090565b602c81908060018154018082558091505090600182039060005260206000200160009091929091909150555080601b6008601081101515610ffe57fe5b018190555050565b602b5481565b6000601b600660108110151561101e57fe5b0154905090565b6000602c80549050905090565b60006003600f60188110151561104457fe5b0154905090565b60006003600460188110151561105d57fe5b0154905090565b60006003600860188110151561107657fe5b0154905090565b60018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156111135780601f106110e857610100808354040283529160200191611113565b820191906000526020600020905b8154815290600101906020018083116110f657829003601f168201915b505050505081565b60006003600960188110151561112d57fe5b0154905090565b6000601b600560108110151561114657fe5b0154905090565b60006003600e60188110151561115f57fe5b0154905090565b60006003601160188110151561117857fe5b0154905090565b600080600091505b60188210156111cd57838281518110151561119e57fe5b906020019060200201516003836018811015156111b757fe5b0181600019169055508180600101925050611187565b600090505b60108110156112145782818151811015156111e957fe5b90602001906020020151601b8260108110151561120257fe5b018190555080806001019150506111d2565b50505050565b60006003600760188110151561122c57fe5b0154905090565b600060038060188110151561124457fe5b0154905090565b80602b816000191690555050565b6000601b600060108110151561126b57fe5b0154905090565b60006003600560188110151561128457fe5b0154905090565b6000601b600160108110151561129d57fe5b0154905090565b60006112ae61168e565b6112b66116b2565b6112be61168e565b60006112c86116b2565b60008092505b6018831015611316576003836018811015156112e657fe5b015484846018811015156112f657fe5b6020020190600019169081600019168152505082806001019350506112ce565b600090505b601081101561135957601b8160108110151561133357fe5b0154828260108110151561134357fe5b602002018181525050808060010191505061131b565b602b54848396509650965050505050909192565b80601b600360108110151561137e57fe5b018190555050565b60006003600060188110151561139857fe5b0154905090565b6000600360106018811015156113b157fe5b0154905090565b6060806000806001600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16828054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156114785780601f1061144d57610100808354040283529160200191611478565b820191906000526020600020905b81548152906001019060200180831161145b57829003601f168201915b50505050509250818054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156115145780601f106114e957610100808354040283529160200191611514565b820191906000526020600020905b8154815290600101906020018083116114f757829003601f168201915b50505050509150925092509250909192565b806003600f60188110151561153757fe5b01816000191690555050565b600081601b600160108110151561155657fe5b018190559050919050565b60006003600660188110151561157357fe5b0154905090565b600080602c8054905011151561159357600090506115b8565b602c6001602c80549050038154811015156115aa57fe5b906000526020600020015490505b90565b80601b60096010811015156115cc57fe5b018190555050565b6003816018811015156115e357fe5b016000915090505481565b60006003600d60188110151561160057fe5b0154905090565b6000601b600760108110151561161957fe5b0154905090565b6000601b600460108110151561163257fe5b0154905090565b602c8181548110151561164857fe5b906000526020600020016000915090505481565b80601b600460108110151561166d57fe5b018190555050565b60006003600160188110151561168757fe5b0154905090565b61030060405190810160405280601890602082028038833980820191505090505090565b610200604051908101604052806010906020820280388339808201915050905050905600a165627a7a72305820d733c005224518d806d7909eeaab9a8fad9eb76fe93bd5ae83368e9cbf0137ee0029";

    public static final String ABI = "[{\"constant\":true,\"inputs\":[],\"name\":\"rmbAmt\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"merchantSvcId\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"name\":\"intArr\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"name\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"msBizNo\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"checkCode\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"meta\",\"type\":\"address\"}],\"name\":\"setMetaAddress\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"merchantId\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_fxRate\",\"type\":\"int256\"}],\"name\":\"setFxRate\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"txAmt\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"merchantSvcName\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_txStatus\",\"type\":\"int256\"}],\"name\":\"setTxStatus\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"date\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"exTimestamp\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[],\"name\":\"txStatusListSize\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"mccCode\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"userAccount\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"userAppIp\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"abi\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"reportCity\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"fxRate\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"merchantOrgCode\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"storeId\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"bytesArrParam\",\"type\":\"bytes32[]\"},{\"name\":\"intArrParam\",\"type\":\"int256[]\"}],\"name\":\"initOrder\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"toOrgId\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"orgBizNo\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_date\",\"type\":\"bytes32\"}],\"name\":\"setDate\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"txType\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"userName\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"isRefunded\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getAllFields\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"},{\"name\":\"\",\"type\":\"bytes32[24]\"},{\"name\":\"\",\"type\":\"int256[16]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_txAmt\",\"type\":\"int256\"}],\"name\":\"setTxAmt\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"ibBizNo\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"txTime\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getMeta\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_txTime\",\"type\":\"bytes32\"}],\"name\":\"setTxTime\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_isRefunded\",\"type\":\"int256\"}],\"name\":\"setIsRefunded\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"fromOrgId\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[],\"name\":\"txStatus\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_checkCode\",\"type\":\"int256\"}],\"name\":\"setCheckCode\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"name\":\"bytes32Arr\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"merchantName\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"tradeTypeValue\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"currency\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"name\":\"txStatusList\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_currency\",\"type\":\"int256\"}],\"name\":\"setCurrency\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"abBizNo\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"inputs\":[{\"name\":\"meta\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"}]";

    public static final TransactionDecoder transactionDecoder = new TransactionDecoder(ABI, BINARY);

    public static final String FUNC_RMBAMT = "rmbAmt";

    public static final String FUNC_MERCHANTSVCID = "merchantSvcId";

    public static final String FUNC_INTARR = "intArr";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_MSBIZNO = "msBizNo";

    public static final String FUNC_CHECKCODE = "checkCode";

    public static final String FUNC_SETMETAADDRESS = "setMetaAddress";

    public static final String FUNC_MERCHANTID = "merchantId";

    public static final String FUNC_SETFXRATE = "setFxRate";

    public static final String FUNC_TXAMT = "txAmt";

    public static final String FUNC_MERCHANTSVCNAME = "merchantSvcName";

    public static final String FUNC_SETTXSTATUS = "setTxStatus";

    public static final String FUNC_DATE = "date";

    public static final String FUNC_EXTIMESTAMP = "exTimestamp";

    public static final String FUNC_TXSTATUSLISTSIZE = "txStatusListSize";

    public static final String FUNC_MCCCODE = "mccCode";

    public static final String FUNC_USERACCOUNT = "userAccount";

    public static final String FUNC_USERAPPIP = "userAppIp";

    public static final String FUNC_ABI = "abi";

    public static final String FUNC_REPORTCITY = "reportCity";

    public static final String FUNC_FXRATE = "fxRate";

    public static final String FUNC_MERCHANTORGCODE = "merchantOrgCode";

    public static final String FUNC_STOREID = "storeId";

    public static final String FUNC_INITORDER = "initOrder";

    public static final String FUNC_TOORGID = "toOrgId";

    public static final String FUNC_ORGBIZNO = "orgBizNo";

    public static final String FUNC_SETDATE = "setDate";

    public static final String FUNC_TXTYPE = "txType";

    public static final String FUNC_USERNAME = "userName";

    public static final String FUNC_ISREFUNDED = "isRefunded";

    public static final String FUNC_GETALLFIELDS = "getAllFields";

    public static final String FUNC_SETTXAMT = "setTxAmt";

    public static final String FUNC_IBBIZNO = "ibBizNo";

    public static final String FUNC_TXTIME = "txTime";

    public static final String FUNC_GETMETA = "getMeta";

    public static final String FUNC_SETTXTIME = "setTxTime";

    public static final String FUNC_SETISREFUNDED = "setIsRefunded";

    public static final String FUNC_FROMORGID = "fromOrgId";

    public static final String FUNC_TXSTATUS = "txStatus";

    public static final String FUNC_SETCHECKCODE = "setCheckCode";

    public static final String FUNC_BYTES32ARR = "bytes32Arr";

    public static final String FUNC_MERCHANTNAME = "merchantName";

    public static final String FUNC_TRADETYPEVALUE = "tradeTypeValue";

    public static final String FUNC_CURRENCY = "currency";

    public static final String FUNC_TXSTATUSLIST = "txStatusList";

    public static final String FUNC_SETCURRENCY = "setCurrency";

    public static final String FUNC_ABBIZNO = "abBizNo";

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

    public RemoteCall<BigInteger> rmbAmt() {
        final Function function = new Function(FUNC_RMBAMT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<byte[]> merchantSvcId() {
        final Function function = new Function(FUNC_MERCHANTSVCID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<BigInteger> intArr(BigInteger param0) {
        final Function function = new Function(FUNC_INTARR, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> name() {
        final Function function = new Function(FUNC_NAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<byte[]> msBizNo() {
        final Function function = new Function(FUNC_MSBIZNO, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<BigInteger> checkCode() {
        final Function function = new Function(FUNC_CHECKCODE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
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

    public RemoteCall<byte[]> merchantId() {
        final Function function = new Function(FUNC_MERCHANTID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
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

    public RemoteCall<BigInteger> txAmt() {
        final Function function = new Function(FUNC_TXAMT, 
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

    public RemoteCall<byte[]> date() {
        final Function function = new Function(FUNC_DATE, 
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

    public RemoteCall<byte[]> mccCode() {
        final Function function = new Function(FUNC_MCCCODE, 
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

    public RemoteCall<byte[]> userAppIp() {
        final Function function = new Function(FUNC_USERAPPIP, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<String> abi() {
        final Function function = new Function(FUNC_ABI, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<byte[]> reportCity() {
        final Function function = new Function(FUNC_REPORTCITY, 
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

    public RemoteCall<byte[]> merchantOrgCode() {
        final Function function = new Function(FUNC_MERCHANTORGCODE, 
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

    public RemoteCall<byte[]> toOrgId() {
        final Function function = new Function(FUNC_TOORGID, 
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

    public RemoteCall<BigInteger> txType() {
        final Function function = new Function(FUNC_TXTYPE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<byte[]> userName() {
        final Function function = new Function(FUNC_USERNAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<BigInteger> isRefunded() {
        final Function function = new Function(FUNC_ISREFUNDED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
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

    public RemoteCall<byte[]> ibBizNo() {
        final Function function = new Function(FUNC_IBBIZNO, 
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

    public RemoteCall<byte[]> fromOrgId() {
        final Function function = new Function(FUNC_FROMORGID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
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

    public RemoteCall<byte[]> bytes32Arr(BigInteger param0) {
        final Function function = new Function(FUNC_BYTES32ARR, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<byte[]> merchantName() {
        final Function function = new Function(FUNC_MERCHANTNAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<BigInteger> tradeTypeValue() {
        final Function function = new Function(FUNC_TRADETYPEVALUE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> currency() {
        final Function function = new Function(FUNC_CURRENCY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> txStatusList(BigInteger param0) {
        final Function function = new Function(FUNC_TXSTATUSLIST, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
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

    public RemoteCall<byte[]> abBizNo() {
        final Function function = new Function(FUNC_ABBIZNO, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
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
