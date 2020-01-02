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
import org.fisco.bcos.web3j.abi.datatypes.Function;
import org.fisco.bcos.web3j.abi.datatypes.Type;
import org.fisco.bcos.web3j.abi.datatypes.Utf8String;
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
public class MerchantFactory extends Contract {
    public static String BINARY = "608060405234801561001057600080fd5b50604051611fab380380611fab83398101806040528101908080518201929190602001805182019291906020018051820192919060200180518201929190505050838381600090805190602001906100699291906101ce565b5080600190805190602001906100809291906101ce565b505050818161008d61024e565b808060200180602001838103835285818151815260200191508051906020019080838360005b838110156100ce5780820151818401526020810190506100b3565b50505050905090810190601f1680156100fb5780820380516001836020036101000a031916815260200191505b50838103825284818151815260200191508051906020019080838360005b83811015610134578082015181840152602081019050610119565b50505050905090810190601f1680156101615780820380516001836020036101000a031916815260200191505b50945050505050604051809103906000f080158015610184573d6000803e3d6000fd5b50600360006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050505050610283565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061020f57805160ff191683800117855561023d565b8280016001018555821561023d579182015b8281111561023c578251825591602001919060010190610221565b5b50905061024a919061025e565b5090565b6040516107398061187283390190565b61028091905b8082111561027c576000816000905550600101610264565b5090565b90565b6115e0806102926000396000f300608060405260043610610078576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063307767b81461007d5780637b4832da14610120578063aa4a1c8c14610163578063b11b6883146101ba578063b40bfca91461024a578063d8fe5476146102da575b600080fd5b34801561008957600080fd5b506100de600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610409565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561012c57600080fd5b50610161600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506104fe565b005b34801561016f57600080fd5b50610178610542565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3480156101c657600080fd5b506101cf610568565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561020f5780820151818401526020810190506101f4565b50505050905090810190601f16801561023c5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561025657600080fd5b5061025f610606565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561029f578082015181840152602081019050610284565b50505050905090810190601f1680156102cc5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b3480156102e657600080fd5b506102ef6106a4565b6040518080602001806020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001838103835286818151815260200191508051906020019080838360005b8381101561036557808201518184015260208101905061034a565b50505050905090810190601f1680156103925780820380516001836020036101000a031916815260200191505b50838103825285818151815260200191508051906020019080838360005b838110156103cb5780820151818401526020810190506103b0565b50505050905090810190601f1680156103f85780820380516001836020036101000a031916815260200191505b509550505050505060405180910390f35b6000808383600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16610439610812565b808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019350505050604051809103906000f0801580156104f1573d6000803e3d6000fd5b5090508091505092915050565b80600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60008054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156105fe5780601f106105d3576101008083540402835291602001916105fe565b820191906000526020600020905b8154815290600101906020018083116105e157829003601f168201915b505050505081565b60018054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561069c5780601f106106715761010080835404028352916020019161069c565b820191906000526020600020905b81548152906001019060200180831161067f57829003601f168201915b505050505081565b6060806000806001600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16828054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156107645780601f1061073957610100808354040283529160200191610764565b820191906000526020600020905b81548152906001019060200180831161074757829003601f168201915b50505050509250818054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156108005780601f106107d557610100808354040283529160200191610800565b820191906000526020600020905b8154815290600101906020018083116107e357829003601f168201915b50505050509150925092509250909192565b604051610d9280610823833901905600608060405234801561001057600080fd5b50604051606080610d9283398101806040528101908080519060200190929190805190602001909291908051906020019092919050505060206040519081016040528060008152506020604051908101604052806000815250816000908051906020019061007f92919061017f565b50806001908051906020019061009692919061017f565b50505082600360006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555081600460006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506101338161013b640100000000026401000000009004565b505050610224565b80600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106101c057805160ff19168380011785556101ee565b828001600101855582156101ee579182015b828111156101ed5782518255916020019190600101906101d2565b5b5090506101fb91906101ff565b5090565b61022191905b8082111561021d576000816000905550600101610205565b5090565b90565b610b5f806102336000396000f300608060405260043610610099576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680637b4832da1461009e578063a8f7ebf4146100e1578063b11b688314610132578063b40bfca9146101c2578063cf9ce6da14610252578063d5e0ff89146102a9578063d8fe547614610323578063e211e0c114610452578063f4aec6fa146104a9575b600080fd5b3480156100aa57600080fd5b506100df600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506104fa565b005b3480156100ed57600080fd5b506101306004803603810190808035600019169060200190929190803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061053e565b005b34801561013e57600080fd5b50610147610627565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561018757808201518184015260208101905061016c565b50505050905090810190601f1680156101b45780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b3480156101ce57600080fd5b506101d76106c5565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156102175780820151818401526020810190506101fc565b50505050905090810190601f1680156102445780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561025e57600080fd5b50610267610763565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3480156102b557600080fd5b506102de600480360381019080803590602001909291908035906020019092919050505061078d565b6040518083601460200280838360005b838110156103095780820151818401526020810190506102ee565b505050509050018281526020019250505060405180910390f35b34801561032f57600080fd5b5061033861088e565b6040518080602001806020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001838103835286818151815260200191508051906020019080838360005b838110156103ae578082015181840152602081019050610393565b50505050905090810190601f1680156103db5780820380516001836020036101000a031916815260200191505b50838103825285818151815260200191508051906020019080838360005b838110156104145780820151818401526020810190506103f9565b50505050905090810190601f1680156104415780820380516001836020036101000a031916815260200191505b509550505050505060405180910390f35b34801561045e57600080fd5b506104676109fc565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3480156104b557600080fd5b506104f86004803603810190808035600019169060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610a26565b005b80600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663a8f7ebf483836040518363ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018083600019166000191681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200192505050600060405180830381600087803b15801561060b57600080fd5b505af115801561061f573d6000803e3d6000fd5b505050505050565b60008054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156106bd5780601f10610692576101008083540402835291602001916106bd565b820191906000526020600020905b8154815290600101906020018083116106a057829003601f168201915b505050505081565b60018054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561075b5780601f106107305761010080835404028352916020019161075b565b820191906000526020600020905b81548152906001019060200180831161073e57829003601f168201915b505050505081565b6000600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905090565b610795610b0f565b6000600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663d5e0ff8985856040518363ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180838152602001828152602001925050506102a060405180830381600087803b15801561083157600080fd5b505af1158015610845573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052506102a081101561086b57600080fd5b810190809190826102800180519060200190929190505050915091509250929050565b6060806000806001600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16828054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561094e5780601f106109235761010080835404028352916020019161094e565b820191906000526020600020905b81548152906001019060200180831161093157829003601f168201915b50505050509250818054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156109ea5780601f106109bf576101008083540402835291602001916109ea565b820191906000526020600020905b8154815290600101906020018083116109cd57829003601f168201915b50505050509150925092509250909192565b6000600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905090565b600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663f4aec6fa83836040518363ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018083600019166000191681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200192505050600060405180830381600087803b158015610af357600080fd5b505af1158015610b07573d6000803e3d6000fd5b505050505050565b610280604051908101604052806014906020820280388339808201915050905050905600a165627a7a7230582020894813743cbfc856a5181ddeca2ba801bf0855f58e313f32366cb8ce9249810029a165627a7a7230582017935f07e99b89e9f49f179de920708532708a594992ead32ee71965c45034a90029608060405234801561001057600080fd5b5060405161073938038061073983398101806040528101908080518201929190602001805182019291905050508160009080519060200190610053929190610072565b50806001908051906020019061006a929190610072565b505050610117565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106100b357805160ff19168380011785556100e1565b828001600101855582156100e1579182015b828111156100e05782518255916020019190600101906100c5565b5b5090506100ee91906100f2565b5090565b61011491905b808211156101105760008160009055506001016100f8565b5090565b90565b610613806101266000396000f300608060405260043610610062576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680637b4832da14610067578063b11b6883146100aa578063b40bfca91461013a578063d8fe5476146101ca575b600080fd5b34801561007357600080fd5b506100a8600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506102f9565b005b3480156100b657600080fd5b506100bf61033d565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156100ff5780820151818401526020810190506100e4565b50505050905090810190601f16801561012c5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561014657600080fd5b5061014f6103db565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561018f578082015181840152602081019050610174565b50505050905090810190601f1680156101bc5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b3480156101d657600080fd5b506101df610479565b6040518080602001806020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001838103835286818151815260200191508051906020019080838360005b8381101561025557808201518184015260208101905061023a565b50505050905090810190601f1680156102825780820380516001836020036101000a031916815260200191505b50838103825285818151815260200191508051906020019080838360005b838110156102bb5780820151818401526020810190506102a0565b50505050905090810190601f1680156102e85780820380516001836020036101000a031916815260200191505b509550505050505060405180910390f35b80600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b60008054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156103d35780601f106103a8576101008083540402835291602001916103d3565b820191906000526020600020905b8154815290600101906020018083116103b657829003601f168201915b505050505081565b60018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156104715780601f1061044657610100808354040283529160200191610471565b820191906000526020600020905b81548152906001019060200180831161045457829003601f168201915b505050505081565b6060806000806001600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16828054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156105395780601f1061050e57610100808354040283529160200191610539565b820191906000526020600020905b81548152906001019060200180831161051c57829003601f168201915b50505050509250818054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156105d55780601f106105aa576101008083540402835291602001916105d5565b820191906000526020600020905b8154815290600101906020018083116105b857829003601f168201915b505050505091509250925092509091925600a165627a7a72305820f617b3ee499d4043dc29c28f8a7e4be5a3862f00075380a3a00be3997550fea40029";

    public static final String ABI = "[{\"constant\":false,\"inputs\":[{\"name\":\"info\",\"type\":\"address\"},{\"name\":\"data\",\"type\":\"address\"}],\"name\":\"create\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"meta\",\"type\":\"address\"}],\"name\":\"setMetaAddress\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"merchantmeta\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"name\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"abi\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getMeta\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"inputs\":[{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"abi\",\"type\":\"string\"},{\"name\":\"merchantname\",\"type\":\"string\"},{\"name\":\"merchantabi\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"}]";

    public static final TransactionDecoder transactionDecoder = new TransactionDecoder(ABI, BINARY);

    public static final String FUNC_CREATE = "create";

    public static final String FUNC_SETMETAADDRESS = "setMetaAddress";

    public static final String FUNC_MERCHANTMETA = "merchantmeta";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_ABI = "abi";

    public static final String FUNC_GETMETA = "getMeta";

    @Deprecated
    protected MerchantFactory(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected MerchantFactory(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected MerchantFactory(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected MerchantFactory(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static TransactionDecoder getTransactionDecoder() {
        return transactionDecoder;
    }

    public RemoteCall<TransactionReceipt> create(String info, String data) {
        final Function function = new Function(
                FUNC_CREATE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(info), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void create(String info, String data, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_CREATE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(info), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(data)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String createSeq(String info, String data) {
        final Function function = new Function(
                FUNC_CREATE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(info), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(data)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<String, String> getCreateInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_CREATE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<String, String>(

                (String) results.get(0).getValue(), 
                (String) results.get(1).getValue()
                );
    }

    public Tuple1<String> getCreateOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_CREATE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
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

    public RemoteCall<String> merchantmeta() {
        final Function function = new Function(FUNC_MERCHANTMETA, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
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

    @Deprecated
    public static MerchantFactory load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new MerchantFactory(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static MerchantFactory load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MerchantFactory(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static MerchantFactory load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new MerchantFactory(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static MerchantFactory load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new MerchantFactory(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<MerchantFactory> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String name, String abi, String merchantname, String merchantabi) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(name), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(abi), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(merchantname), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(merchantabi)));
        return deployRemoteCall(MerchantFactory.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<MerchantFactory> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String name, String abi, String merchantname, String merchantabi) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(name), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(abi), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(merchantname), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(merchantabi)));
        return deployRemoteCall(MerchantFactory.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<MerchantFactory> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String name, String abi, String merchantname, String merchantabi) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(name), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(abi), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(merchantname), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(merchantabi)));
        return deployRemoteCall(MerchantFactory.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<MerchantFactory> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String name, String abi, String merchantname, String merchantabi) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(name), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(abi), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(merchantname), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(merchantabi)));
        return deployRemoteCall(MerchantFactory.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
